plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
    sourceSets["commonMain"].dependencies {
        api(Module.library.logger)
        api(Dependency.kermit)
    }
}
