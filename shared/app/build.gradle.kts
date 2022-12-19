plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

apply<ModuleApp>()

android {
    namespace = "cocktailsKMM.app"
}

kotlin {
    sourceSets["commonMain"].dependencies {
        with(Module.feature) {
            implementation(ingredients)
        }

        with(Module.generic) {
            implementation(deviceIngredients)
            implementation(network)
            implementation(storage)
        }

        with(Module.library) {
            implementation(activity)
            implementation(architecture)
            implementation(architectureFixtures)
            implementation(coroutines)
            implementation(coroutinesFixtures)
            implementation(koinKtx)
            implementation(logger)
            implementation(loggerKermit)
            implementation(loggerKoin)
            implementation(mvvm)
            implementation(navigation)
        }
    }

    sourceSets["androidMain"].dependencies {
        implementation(Module.library.loggerKermit)
        implementation(Dependency.Ktor.Engine.android)
        implementation(Dependency.SqlDelight.androidDriver)
    }

    sourceSets["iosMain"].dependencies {
        implementation(Module.library.loggerKermit)
        implementation(Dependency.Ktor.Engine.ios)
        implementation(Dependency.SqlDelight.iosDriver)
    }
}