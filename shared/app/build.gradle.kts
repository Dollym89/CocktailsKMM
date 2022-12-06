plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

apply<ModuleApp>()

android {
    namespace = "cocktailsKMM.app"
}

kotlin {
    sourceSets["commonMain"].dependencies {
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