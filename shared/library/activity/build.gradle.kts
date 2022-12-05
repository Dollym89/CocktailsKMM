plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

apply<ModuleLibraryAndroid>()
apply<ConfigCoroutines>()

kotlin {
    sourceSets["androidMain"].dependencies {
        implementation(Dependency.AndroidX.appcompat)
        implementation(Module.library.koinKtx)
    }
}
