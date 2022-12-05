import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.plugins.JavaPluginExtension
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinTargetContainerWithNativeShortcuts
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

@Suppress("ClassName")
internal object local

internal infix fun local.plugin(config: Project.() -> Unit) = Plugin<Project> { config(it) }

internal fun KotlinMultiplatformExtension.explicitApiAndroid() {
    targets.all {
        compilations.all {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xexplicit-api=strict"
            }
        }
    }
}

internal fun Project.androidApplication(block: ApplicationExtension.() -> Unit) {
    extensions.findByType<ApplicationExtension>()?.apply(block)
}

internal fun Project.androidLibrary(block: LibraryExtension.() -> Unit) {
    extensions.findByType<LibraryExtension>()?.apply(block)
}

internal fun Project.android(block: LibraryExtension.() -> Unit) {
    extensions.findByType<LibraryExtension>()?.apply(block)
}

internal fun Project.java(block: JavaPluginExtension.() -> Unit) {
    extensions.findByType<JavaPluginExtension>()?.apply(block)
}

internal fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.findByType<KotlinMultiplatformExtension>()?.apply(block)
}

@Suppress("UNCHECKED_CAST")
internal fun <T> Project.typedProperty(name: String): T? = findProperty(name) as T?

fun KotlinTargetContainerWithNativeShortcuts.iosAll(
    configure: KotlinNativeTarget.() -> Unit = {}
) {
    ios(configure = configure)
    iosSimulatorArm64(configure = configure)
    sourceSets.maybeCreate("iosSimulatorArm64Main").apply {
        dependsOn(sourceSets.getByName("iosMain"))
    }
}
