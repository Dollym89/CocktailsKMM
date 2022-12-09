import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigStorage : Plugin<Project> by local plugin {
    kotlin {
        sourceSets["commonMain"].dependencies {
//            implementation(Module.generic.storage)
        }
        sourceSets["androidTest"].dependencies {
//            implementation(Module.generic.storageFixtures)
        }
    }
}
