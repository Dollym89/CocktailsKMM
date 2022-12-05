import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ModuleAndroidLibrary : Plugin<Project> by local plugin {
    apply<ConfigAndroidBuild>()
    apply<ConfigCompiler>()
    apply<ConfigCompose>()
}
