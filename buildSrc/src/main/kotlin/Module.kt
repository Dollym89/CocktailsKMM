import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Feature(factory: DependencyFactory) : ModuleType(factory, "feature") {
    val ingredients by module()
}

class Generic(factory: DependencyFactory) : ModuleType(factory, "generic") {
    val deviceIngredients by module()
    val network by module()
    val storage by module()
}

class Library(factory: DependencyFactory) : ModuleType(factory, "library") {
    val activity by module()
    val architecture by module()
    val architectureFixtures by module()
    val coroutines by module()
    val coroutinesFixtures by module()
    val koinKtx by module()
    val logger by module()
    val loggerKermit by module()
    val loggerKoin by module()
    val mvvm by module()
    val navigation by module()
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
