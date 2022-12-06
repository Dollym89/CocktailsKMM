import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
}

detekt {
    source = files("$projectDir")
    config = files("$projectDir/detekt.yml")
    parallel = true
}

tasks.withType<Detekt> {
    exclude("**/build/**")
    exclude("**/buildSrc/**")
    exclude("**/*gradle.kts")
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
