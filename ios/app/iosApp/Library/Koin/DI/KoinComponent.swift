import Multiplatform

protocol KoinComponent {}

extension KoinComponent {
    func get<T>(_ type: T.Type = T.self) -> T {
        getKoin().get(type)
    }

    private func getKoin() -> Koin {
        KoinPlatformTools().defaultContext().get()
    }
}

protocol KoinResolver {
    func get(clazz: KotlinKClass, qualifier: Qualifier?, parameters: (() -> ParametersHolder)?) -> Any?
}

extension KoinResolver {
    func get<T>(_ type: T.Type = T.self) -> T {
        get(
            clazz: KClass(for: type),
            qualifier: nil,
            parameters: nil
        ) as! T // swiftlint:disable:this force_cast
    }
}

extension Koin: KoinResolver {}
extension Scope: KoinResolver {}
