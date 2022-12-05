import org.gradle.api.Plugin
import org.gradle.api.Project

import org.gradle.kotlin.dsl.get

class ConfigAndroidView : Plugin<Project> by local plugin {
    android {
        buildFeatures.viewBinding = true
    }

    kotlin {
        sourceSets["commonMain"].dependencies {
//            implementation(Module.generic.design)
            implementation(Module.library.mvvm)
        }
    }
}
