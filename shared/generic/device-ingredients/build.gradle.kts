plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

apply<ModuleGeneric>()

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                with(Module) {
                    implementation(library.logger)
                    implementation(generic.network)
                    implementation(generic.storage)
                }
                with(Dependency.Ktor) {
                    implementation(auth)
                    implementation(contentNegotiation)
                    implementation(core)
                    implementation(json)
                    implementation(logging)
                    implementation(serialization)
                }
            }
        }
    }
}
