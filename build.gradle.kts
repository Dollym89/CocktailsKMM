import io.gitlab.arturbosch.detekt.Detekt

//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("7.3.1").apply(false)
//    id("com.android.library").version("7.3.1").apply(false)
//    kotlin("android").version("1.7.10").apply(false)
//    kotlin("multiplatform").version("1.7.10").apply(false)
//}

plugins {
    id("com.github.ben-manes.versions") version "0.39.0"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
}

detekt {
    source = files("$projectDir")
    config = files("$projectDir/detekt.yml")
    parallel = true
    reports {
        xml.enabled = false
        txt.enabled = false
    }
    autoCorrect = true
}

tasks.withType<Detekt> {
    exclude("**/*gradle.kts")
    exclude("**/build/**")
    exclude("**/buildSrc/**")
    exclude("resources")
    exclude(".idea")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// This should not be here - only on buildSrc build.gradle file should be this declared, but there is something
// weird with kotlin and compose versions currently used. When bumping versions, try remove.
allprojects {
    repositories {
        google()
        mavenCentral()
        // For dev version of kotlin and compose. When not dev version is used, try remove.
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
        maven("https://androidx.dev/storage/compose-compiler/repository/")
    }
}
