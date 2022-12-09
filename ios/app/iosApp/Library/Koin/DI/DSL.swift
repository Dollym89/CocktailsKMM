import Multiplatform

func module(declaration: @escaping (Module) -> Void) -> Module {
    let module = Module()
    declaration(module)
    return module
}

func startKoin(appDeclaration: @escaping (KoinApplication) -> Void) -> KoinApplication {
    DefaultContextExtKt.startKoin(appDeclaration: appDeclaration)
}

func stopKoin() {
    DefaultContextExtKt.stopKoin()
}

extension KoinApplication {
    func modules(_ modules: Module ...) {
        koin.loadModules(modules)
    }
}
