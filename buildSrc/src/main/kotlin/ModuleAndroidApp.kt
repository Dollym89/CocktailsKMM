import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ModuleAndroidApp : Plugin<Project> by local plugin {
    apply<ConfigAndroidBuild>()
    apply<ConfigAndroidLint>()
    apply<ConfigCompiler>()
}
