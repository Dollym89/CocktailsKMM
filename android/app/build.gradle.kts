plugins {
    id("com.android.application")
    kotlin("android")
}

apply<ModuleAndroidApp>()
apply<ConfigCompose>()

dependencies {
    implementation(project(":shared:app"))
    implementation(Module.library.activity)
    implementation(Module.library.architecture)
    implementation(Module.library.coroutines)
    implementation(Module.library.koinKtx)
    implementation(Module.library.logger)
    implementation(Module.library.mvvm)

    testImplementation(Module.library.architectureFixtures)
    testImplementation(Module.library.coroutinesFixtures)
}

configurations.all {
    resolutionStrategy {
        force(Dependency.Coroutines.core)
    }
}

android {
    namespace = "com.example.cocktailskmm.android"

    defaultConfig {
        applicationId = "com.example.cocktailskmm.android"
//        resourceConfigurations += setOf("en")
    }
    buildFeatures {
        buildConfig = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
