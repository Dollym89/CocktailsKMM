plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
apply<ModuleFeature>()

android {
    namespace = "iot.feature.scan"
}

kotlin {
    sourceSets["commonMain"].dependencies {
        implementation(Module.generic.network)
        with(Dependency.Ktor) {
            implementation(auth)
            implementation(contentNegotiation)
            implementation(core)
            implementation(json)
            implementation(logging)
            implementation(serialization)
        }
    }
    sourceSets["androidTest"].dependencies {

    }
}
