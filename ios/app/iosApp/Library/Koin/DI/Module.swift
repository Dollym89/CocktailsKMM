import Multiplatform

final class Module {
    private(set) var mappings = [String: InstanceFactory<AnyObject>]()

    private let rootScope = QualifierKt.named(name: "_")

    func addMapping(_ key: String, _ factory: InstanceFactory<AnyObject>) {
        mappings[key] = factory
    }

    func makeDefinition<T>(
        for type: T.Type,
        definition: @escaping (Scope) -> T,
        kind: Kind
    ) -> BeanDefinition<AnyObject> {
        BeanDefinition<AnyObject>(
            scopeQualifier: rootScope,
            primaryType: KClass(for: type),
            qualifier: nil,
            definition: { scope, _ in definition(scope) as AnyObject },
            kind: kind,
            secondaryTypes: []
        )
    }

    func makeKey<T>(for type: T.Type) -> String {
        BeanDefinitionKt.indexKey(
            clazz: KClass(for: type),
            typeQualifier: nil,
            scopeQualifier: rootScope
        )
    }

    struct Entry<Instance> {
        let module: Module
        let factory: InstanceFactory<AnyObject>
    }
}

extension Koin {
    func loadModules(_ modules: [Module]) {
        instanceRegistry.loadModules(modules)
        scopeRegistry.loadScopes(from: modules)
    }
}

extension ScopeRegistry {
    func loadScopes(from modules: [Module]) {
        // API for customization not available
    }
}

extension InstanceRegistry {
    func loadModules(_ modules: [Module]) {
        modules.forEach {
            loadModule($0)
            addEagerInstances(from: $0)
        }
    }

    private func addEagerInstances(from module: Module) {
        // API for customization not available
    }

    private func loadModule(_ module: Module) {
        module.mappings.forEach { index, factory in
            saveMapping(
                allowOverride: false,
                mapping: index,
                factory: factory,
                logWarning: true
            )
        }
    }
}
