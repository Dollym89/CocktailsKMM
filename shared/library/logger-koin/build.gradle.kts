plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
    sourceSets["commonMain"].dependencies {
        implementation(Module.library.logger)
        api(Dependency.Koin.core)
    }
}
