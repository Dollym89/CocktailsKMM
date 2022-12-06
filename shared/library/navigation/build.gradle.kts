plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

apply<ModuleLibraryAndroid>()

kotlin {
//    sourceSets.all {
//        languageSettings.apply {
//            useExperimentalAnnotation("kotlinx.coroutines.FlowPreview")
//        }
//    }
    sourceSets["androidMain"].dependencies {
        api(Dependency.AndroidX.Navigation.fragment)
        api(Dependency.AndroidX.Navigation.ui)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlinx.coroutines.FlowPreview"
    }
}