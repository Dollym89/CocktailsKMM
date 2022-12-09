import Multiplatform

extension Module.Entry {
    @discardableResult
    func binds<T>(_ type: T.Type) -> Self {
        factory.beanDefinition.secondaryTypes.append(KClass(for: type))
        module.addMapping(module.makeKey(for: type), factory)
        return self
    }
}
