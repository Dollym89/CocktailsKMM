import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigCoroutines : Plugin<Project> by local plugin {
    kotlin {
        sourceSets.all {
            languageSettings {
                optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
                optIn("kotlinx.coroutines.FlowPreview")
            }
        }
        sourceSets["commonMain"].dependencies {
            implementation(Module.library.coroutines)
        }
        sourceSets["androidMain"].dependencies {
            api(Dependency.Coroutines.android)
        }
        sourceSets["androidTest"].dependencies {
            implementation(Module.library.architectureFixtures)
            implementation(Module.library.coroutinesFixtures)
            implementation(Dependency.Coroutines.test)
        }
    }

    configurations.all {
        resolutionStrategy {
            force(Dependency.Coroutines.core)
        }
    }
}
