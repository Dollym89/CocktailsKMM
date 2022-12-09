import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigTestAndroid : Plugin<Project> by local plugin {
    kotlin {
        sourceSets["androidTest"].dependencies {
            implementation(Dependency.JUnit.params)
            implementation(Dependency.JUnit.runtime)
            implementation(Dependency.Kotest.assertions)
            implementation(Dependency.Mockk.kotlin)
        }
    }
}
