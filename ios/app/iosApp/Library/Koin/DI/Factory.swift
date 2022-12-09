// swiftlint:disable line_length
import Multiplatform

extension Module {
    @discardableResult func factory<T>(
        of type: T.Type = T.self,
        definition: @escaping (Scope) -> T
    ) -> Module.Entry<T> {
        let definition = makeDefinition(for: type, definition: definition, kind: .factory)
        let key = makeKey(for: type)
        let factory = FactoryInstanceFactory(beanDefinition: definition)
        addMapping(key, factory)
        return Module.Entry<T>(module: self, factory: factory)
    }

    @discardableResult func factory<T>(
        of type: T.Type = T.self,
        using initializer: @escaping () -> T
    ) -> Module.Entry<T> {
        factory { _ in initializer() }
    }

    @discardableResult @_disfavoredOverload func factory<A1, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1) -> T
    ) -> Module.Entry<T> {
        checkForTuple(type, argument: A1.self)
        return factory { initializer($0.get()) }
    }

    @discardableResult func factory<A1, A2, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }

    @discardableResult func factory<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, T>(
        of type: T.Type = T.self,
        using initializer: @escaping (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) -> T
    ) -> Module.Entry<T> {
        factory { initializer($0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get(), $0.get()) }
    }
}
