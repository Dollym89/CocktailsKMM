import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

class ConfigDatabase : Plugin<Project> by local plugin {
    kotlin {
        sourceSets["commonMain"].dependencies {
//            implementation(Module.generic.database)
            implementation(Dependency.SqlDelight.coroutines)
        }
    }
}