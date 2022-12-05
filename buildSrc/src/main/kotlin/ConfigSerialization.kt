import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get

class ConfigSerialization : Plugin<Project> by local plugin {

    apply(plugin = "kotlinx-serialization")

    kotlin {
        sourceSets["commonMain"].dependencies {
            implementation(Dependency.Serialization.core)
        }
    }
}
