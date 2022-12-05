import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get

class ModuleGeneric : Plugin<Project> by local plugin {

    kotlin {
        explicitApi()
        explicitApiAndroid()

        android()
        iosAll()
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
            implementation(Module.library.koinKtx)
//            implementation(Module.library.localisation)
            implementation(Module.library.logger)
        }
    }
}
