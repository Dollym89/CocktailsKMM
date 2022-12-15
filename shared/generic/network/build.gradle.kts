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
                }

                with(Dependency.Serialization) {
                    implementation(core)
                    implementation(json)
                }

                with(Dependency.Ktor) {
                    implementation(auth)
                    implementation(contentNegotiation)
                    implementation(core)
                    implementation(json)
                    implementation(logging)
                    implementation(serialization)
                    implementation(websockets)
                }

            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependency.Ktor.Engine.android)
                implementation(Dependency.okHttp)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(Dependency.Ktor.Engine.ios)
            }
        }
    }
}
