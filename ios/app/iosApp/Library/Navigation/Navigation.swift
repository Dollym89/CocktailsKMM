import SwiftUI

struct NavigationState {
    private var data = [ObjectIdentifier: Bool]()

    subscript<V: View>(key: V.Type) -> Bool {
        get { data[ObjectIdentifier(key)] ?? false  }
        set { data[ObjectIdentifier(key)] = newValue }
    }
}

enum NavigationLinkType {
    case link
    case sheet
    case sheetWithNavigation
    case fullscreen
    case fullscreenWithNavigation
}

struct NavigationLinkParams<V> {
    let view: V.Type
    let type: NavigationLinkType
}

protocol Navigation: ObservableObject, KoinComponent {
    associatedtype Routes: View
    typealias State = NavigationState
    typealias LinkType = NavigationLinkType
    typealias LinkParams<V: View> = NavigationLinkParams<V>

    var state: NavigationState { get set }

    @ViewBuilder func routes(for screen: Any.Type) -> Routes
}

private extension NavigationLink where Label == EmptyView {
    init(isActive: Binding<Bool>, destination: () -> Destination) {
        self.init(isActive: isActive, destination: destination) { EmptyView() }
    }
}

extension Navigation {
    func open<V: View>(_ view: V.Type) {
        state[view] = true
    }

    func close<V: View>(_ view: V.Type) {
        state[view] = false
    }

    func screen<V: View>(for view: V.Type) -> some View {
        VStack {
            get(view)
            ScreenRouter<V, Self>(navigation: self)
        }
        .environment(\.close) { self.close(view) }
    }

    func link<V: View>(_ view: V.Type, type: LinkType = .link) -> some View {
        link(for: .init(view: view, type: type))
    }

    @ViewBuilder
    private func link<V: View>(for params: LinkParams<V>) -> some View {
        switch params.type {
        case .link:
            NavigationLink(isActive: binding(for: V.self)) { self.linkTarget(for: params) }
        case .sheet, .sheetWithNavigation:
            VStack {}.sheet(isPresented: binding(for: V.self)) { self.linkTarget(for: params) }
        case .fullscreen, .fullscreenWithNavigation:
            VStack {}.fullScreenCover(isPresented: binding(for: V.self)) { self.linkTarget(for: params) }
        }
    }

    @ViewBuilder
    private func linkTarget<V: View>(for params: LinkParams<V>) -> some View {
        switch params.type {
        case .fullscreenWithNavigation, .sheetWithNavigation:
            NavigationView { screen(for: params.view) }.navigationViewStyle(.stack)
        case .fullscreen, .sheet, .link:
            screen(for: params.view)
        }
    }

    fileprivate func binding<V: View>(for view: V.Type) -> Binding<Bool> {
        Binding(
            get: { self.state[view] },
            set: { self.state[view] = $0 }
        )
    }
}

private struct ScreenRouter<Screen, Navig>: View where Screen: View, Navig: Navigation {
    @ObservedObject var navigation: Navig

    var body: some View {
        navigation.routes(for: Screen.self)
    }
}

private struct Router<Routes, Navig>: View where Routes: View, Navig: Navigation {
    @ObservedObject var navigation: Navig
    let routes: () -> Routes

    var body: some View {
        routes()
    }
}

extension View {
    func popover<N: Navigation, V: View>(_ navigation: N, to view: V.Type) -> some View {
        Router(navigation: navigation) {
            popover(isPresented: navigation.binding(for: view)) { navigation.screen(for: view) }
        }
    }
}
