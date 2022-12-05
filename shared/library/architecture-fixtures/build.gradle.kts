plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
    sourceSets["jvmMain"].dependencies {
        implementation(Module.library.architecture)
        implementation(Dependency.Mockk.kotlin)
        implementation(Dependency.Kotest.assertions)
    }
}
