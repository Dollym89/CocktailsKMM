import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidLint : Plugin<Project> by local plugin {
    android {
        lintOptions {
            isCheckDependencies = true
            isIgnoreTestSources = true
            xmlReport = false
            baseline(file("lint-baseline.xml"))
        }
    }
}
