import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get

class ModuleLibraryAndroid : Plugin<Project> by local plugin {
    kotlin {
        explicitApi()
        explicitApiAndroid()

        android()
        ios()
    }

    apply<ConfigAndroidBuild>()
    apply<ConfigAndroidLint>()
    apply<ConfigAndroidSourceSet>()
    apply<ConfigCompiler>()
    apply<ConfigCoroutines>()
    apply<ConfigTestAndroid>()

    kotlin {
        sourceSets["commonMain"].dependencies {
            implementation(Module.library.architecture)
            implementation(Module.library.logger)
            implementation(Dependency.Koin.core)
        }
    }
}
