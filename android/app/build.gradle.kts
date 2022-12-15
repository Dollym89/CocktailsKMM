plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
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
    implementation(Module.library.navigation)

    implementation(Module.feature.ingredient)

    testImplementation(Module.library.architectureFixtures)
    testImplementation(Module.library.coroutinesFixtures)

    testImplementation(Dependency.Coroutines.test)
    testImplementation(Dependency.JUnit.params)
    testImplementation(Dependency.Koin.test)
    testImplementation(Dependency.Kotest.assertions)
    testImplementation(Dependency.Mockk.kotlin)
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
