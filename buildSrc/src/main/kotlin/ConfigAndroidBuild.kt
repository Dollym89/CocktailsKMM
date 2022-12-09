import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidBuild : Plugin<Project> by local plugin {
    android {
        compileSdk = Android.Sdk.compile

        defaultConfig {
            minSdk = Android.Sdk.min
            targetSdk = Android.Sdk.target
        }
    }

    androidApplication {
        compileSdk = Android.Sdk.compile

        defaultConfig {
            minSdk = Android.Sdk.min
            targetSdk = Android.Sdk.target
        }
    }
}
