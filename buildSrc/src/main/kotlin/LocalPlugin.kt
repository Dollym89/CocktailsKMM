import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.plugins.JavaPluginExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

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

internal fun Project.android(block: BaseExtension.() -> Unit) {
    extensions.findByType(BaseExtension::class.java)?.apply(block)
}

internal fun Project.java(block: JavaPluginExtension.() -> Unit) {
    extensions.findByType(JavaPluginExtension::class.java)?.apply(block)
}

internal fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.findByType(KotlinMultiplatformExtension::class.java)?.apply(block)
}

@Suppress("UNCHECKED_CAST")
internal fun <T> Project.typedProperty(name: String): T? = findProperty(name) as T?

internal fun ModuleDependency.exclude(group: String?, module: String? = null) {
    // TODO use buildMap() once it won't be experimental, maybe in Kotlin 1.5
    exclude(
        mutableMapOf<String, String>().apply {
            group?.let { put("group", it) }
            module?.let { put("module", it) }
        },
    )
}
