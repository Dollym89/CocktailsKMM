import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigTestAndroid : Plugin<Project> by local plugin {
    kotlin {
        sourceSets["androidTest"].dependencies {
            implementation(Dependency.JUnit.params)
            implementation(Dependency.JUnit.core)
            implementation(Dependency.Test.turbine)
            implementation(Dependency.kotest)
            implementation(Dependency.mockk)
            runtimeOnly(Dependency.Serialization.core)
        }
    }
}
