plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

apply<ModuleGeneric>()

kotlin {
    sourceSets["commonMain"].dependencies {
        implementation(Module.library.logger)
//        implementation(Module.generic.preferences)
        implementation(Dependency.Serialization.core)
        implementation(Dependency.Serialization.json)

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
    sourceSets["androidMain"].dependencies {
        implementation(Dependency.Ktor.Engine.android)
        implementation(Dependency.okHttp)
    }
    sourceSets["iosMain"].dependencies {
        implementation(Dependency.Ktor.Engine.ios)
    }
}
