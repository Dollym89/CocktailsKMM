plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
    sourceSets["commonMain"].dependencies {
        api(Dependency.Coroutines.core)
        implementation(Dependency.DateTime.core)
    }
    sourceSets["jvmTest"].dependencies {
        implementation(Module.library.coroutinesFixtures)
        implementation(Dependency.Coroutines.test)
    }
}
