import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ModuleLibraryJvm : Plugin<Project> by local plugin {
    kotlin {
        explicitApi()

        jvm()
        iosAll()
    }

    apply<ConfigCompiler>()
    apply<ConfigTestJvm>()
}
