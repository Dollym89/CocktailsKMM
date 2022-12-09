import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidLint : Plugin<Project> by local plugin {
    android {
        lint {
            checkDependencies = true
            ignoreTestSources = true
            xmlReport = false
        }
    }
}
