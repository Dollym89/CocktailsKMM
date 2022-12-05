import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigTestJvm : Plugin<Project> by local plugin {
    kotlin {
        sourceSets["jvmTest"].dependencies {
            implementation(Dependency.JUnit.params)
            implementation(Dependency.JUnit.core)
            implementation(Dependency.kotest)
            implementation(Dependency.mockk)
            runtimeOnly(Dependency.Serialization.core)
        }
    }
}
