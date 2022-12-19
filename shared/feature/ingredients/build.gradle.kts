plugins {
    kotlin("multiplatform")
    id("com.android.library")
}
apply<ModuleFeature>()

android {
    namespace = "iot.feature.scan"
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Module.generic.deviceIngredients)
                implementation(Module.library.logger)
            }
        }
    }
}
