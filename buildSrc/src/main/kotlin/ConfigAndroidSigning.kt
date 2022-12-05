import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidSigning : Plugin<Project> by local plugin {
    android {
        signingConfigs {
            getByName("debug") {
                // Local builds
                storeFile = project.file("debug.keystore")
                storePassword = "android"
                keyAlias = "androiddebugkey"
                keyPassword = "android"
            }
            create("release") {
                keyAlias = "upload"
                keyPassword = "g!oba!st*r2019"
                storeFile = file("upload-keystore.jks")
                storePassword = "g!oba!st*r2019"
            }
        }
    }
}
