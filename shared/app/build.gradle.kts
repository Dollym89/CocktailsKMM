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
        implementation(Module.feature.ingredient)
        implementation(Module.generic.network)

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
}