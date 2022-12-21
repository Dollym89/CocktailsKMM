import Multiplatform
import Combine
import SwiftUI

@propertyWrapper
struct ViewModel<State: AnyObject, ViewModel: BaseViewModel<State>>: DynamicProperty {
    @ObservedObject private var observable: Observable<State, ViewModel>

    var wrappedValue: ViewModel { observable.value }

    var projectedValue: Bindable<ViewModel> {
        Bindable { observable.value }
    }

    init(viewModel: ViewModel) {
        observable = Observable(viewModel)
    }

    init(wrappedValue: ViewModel) {
        self.init(viewModel: wrappedValue)
    }

    private final class Observable<State: AnyObject, ViewModel: BaseViewModel<State>>: ObservableObject {
        let value: ViewModel

        init(_ value: ViewModel) {
            self.value = value
        }

        var objectWillChange: AnyPublisher<Void, Never> {
            Ktx.publisher(for: value.changes).map { _ in }.eraseToAnyPublisher()
        }
    }

    @dynamicMemberLookup
    struct Bindable<Value> {
        fileprivate let get: () -> Value

        subscript<Field>(dynamicMember keyPath: KeyPath<Value, Field>) -> Bindable<Field> {
            Bindable<Field> { get()[keyPath: keyPath] }
        }

        func bind(by set: @escaping (Value) -> Void) -> Binding<Value> {
            Binding(get: get, set: set)
        }
    }
}

// MARK: - Bidning optional values

protocol OptionalProtocol {
    associatedtype Wrapped
    func ifNilThen(_ defaultValue: Wrapped) -> Wrapped
}

extension Optional: OptionalProtocol {
    func ifNilThen(_ defaultValue: Wrapped) -> Wrapped {
        self ?? defaultValue
    }
}

protocol Defaultable {
    static var `default`: Self { get }
}

extension String: Defaultable {
    static let `default` = ""
}

extension ViewModel.Bindable where Value: OptionalProtocol, Value.Wrapped: Defaultable {

    func bind(by set: @escaping (Value.Wrapped) -> Void) -> Binding<Value.Wrapped> {
        Binding(
            get: { get().ifNilThen(.default) },
            set: { set($0) }
        )
    }
}
