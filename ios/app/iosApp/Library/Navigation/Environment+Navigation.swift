import SwiftUI

extension EnvironmentValues {
    private struct CloseActionKey: EnvironmentKey {
        static let defaultValue = {}
    }

    typealias CloseAction = () -> Void

    var close: CloseAction {
        get { self[CloseActionKey.self] }
        set { self[CloseActionKey.self] = newValue }
    }
}
