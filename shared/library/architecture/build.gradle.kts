plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(Dependency.Coroutines.core)
            }
        }
    }
}
