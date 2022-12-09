import Multiplatform

class SwiftKClass<T>: NSObject, KotlinKClass {
    func isInstance(value: Any?) -> Bool {
        value is T
    }

    var qualifiedName: String? {
        String(reflecting: T.self)
    }

    var simpleName: String? {
        String(describing: T.self)
    }
}

func KClass<T>(for type: T.Type) -> KotlinKClass {
    SwiftType(type: type, swiftClazz: SwiftKClass<T>()).getClazz()
}
