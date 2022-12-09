import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get

class ConfigCompose: Plugin<Project> by local plugin {
    android {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Dependency.Compose.kotlinCompilerVersion
        }
    }
    androidApplication {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Dependency.Compose.kotlinCompilerVersion
        }
    }

    kotlin {
        sourceSets["androidMain"].dependencies {
            api(Dependency.Compose.activity)
            api(Dependency.Compose.compiler)
            api(Dependency.Compose.foundation)
            api(Dependency.Compose.material)
            api(Dependency.Compose.runtime)
            api(Dependency.Compose.tooling)
            api(Dependency.Compose.toolingPreview)
            api(Dependency.Compose.ui)
        }
    }
}
