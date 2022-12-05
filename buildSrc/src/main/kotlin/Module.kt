import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class Feature(factory: DependencyFactory) : ModuleType(factory, "feature") {
    val configuration by module()
    val detail by module()
    val diagnostics by module()
    val login by module()
    val multideviceConfig by module()
    val multideviceUpdate by module()
    val powerOff by module()
    val profileActions by module()
    val scan by module()
    val settings by module()
    val singledeviceUpdate by module()
}

class Generic(factory: DependencyFactory) : ModuleType(factory, "generic") {
    val account by module()
    val app by module()
    val biometrics by module()
    val bluetooth by module()
    val bottombar by module()
    val common by module()
    val configurationField by module()
    val design by module()
    val developerMode by module()
    val device by module()
    val deviceCommands by module()
    val deviceConfig by module()
    val deviceFixtures by module()
    val deviceNavigation by module()
    val deviceScan by module()
    val dialog by module()
    val exportReport by module()
    val filter by module()
    val firmware by module()
    val health by module()
    val localisation by module()
    val logger by module()
    val loggerFile by module()
    val loggerUpload by module()
    val mls by module()
    val multidevice by module()
    val network by module()
    val preferences by module()
    val profile by module()
    val product by module()
    val security by module()
    val storage by module()
    val storageFixtures by module()
    val time by module()
    val topappbar by module()
    val version by module()
    val versionFixtures by module()
    val userGuide by module()
}

class Library(factory: DependencyFactory) : ModuleType(factory, "library") {
    val architecture by module()
    val architectureFixtures by module()
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
