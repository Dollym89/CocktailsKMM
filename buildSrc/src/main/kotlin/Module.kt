import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class Feature(factory: DependencyFactory) : ModuleType(factory, "feature") {

}

class Generic(factory: DependencyFactory) : ModuleType(factory, "generic") {

}

class Library(factory: DependencyFactory) : ModuleType(factory, "library") {
    val architecture by module()
    val architectureFixtures by module()
    val coroutines by module()
    val coroutinesFixtures by module()
    val koinKtx by module()
    val mvvm by module()
}

abstract class ModuleType(
    private val factory: DependencyFactory,
    private val type: String,
) {
    fun module() = ReadOnlyProperty<ModuleType, ProjectDependency> { _, property ->
        factory(":shared:$type:${property.name()}")
    }

    private fun KProperty<*>.name() = name.camelToKebab()
    private fun String.camelToKebab() = map { it.camelToKebab() }.joinToString(separator = "")
    private fun Char.camelToKebab() = if (isUpperCase()) "-${toLowerCase()}" else "$this"
}

class ModuleFactory(factory: DependencyFactory) {
    val feature = Feature(factory)
    val generic = Generic(factory)
    val library = Library(factory)
}

val DependencyHandler.Module: ModuleFactory get() = ModuleFactory { project(it) }
val KotlinDependencyHandler.Module: ModuleFactory get() = ModuleFactory { project(it) }

private typealias DependencyFactory = (String) -> ProjectDependency
