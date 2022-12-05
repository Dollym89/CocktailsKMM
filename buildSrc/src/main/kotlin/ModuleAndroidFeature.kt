import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get

class ModuleAndroidFeature : Plugin<Project> by local plugin {

    apply<ConfigAndroidBuild>()
    apply<ConfigCompose>()

    dependencies {
        "implementation"(Dependency.AndroidX.fragment)
        "implementation"(Dependency.Compose.activity)
//        "implementation"(Module.androidLibrary.compose)
        "implementation"(Module.library.koinKtx)
        "implementation"(Module.library.logger)
        "implementation"(Module.library.mvvm)
//        "implementation"(Module.library.navigation)
    }
}