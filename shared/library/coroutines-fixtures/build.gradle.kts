plugins {
    kotlin("multiplatform")
}

apply<ModuleLibraryJvm>()

kotlin {
//    sourceSets.all {
//        languageSettings.apply {
//            useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
//        }
//    }
    sourceSets["jvmMain"].dependencies {
        implementation(Module.library.coroutines)
        implementation(Dependency.Coroutines.test)
        implementation(Dependency.JUnit.runtime)
        implementation(Dependency.Mockk.kotlin)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlinx.coroutines.FlowPreview"
    }
}