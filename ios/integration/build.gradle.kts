plugins {
    kotlin("multiplatform")
}

kotlin {
    val projectDependencies = listOf(
        project(":shared:app"),
//        project(":shared:feature:dashboard"),
//        project(":shared:feature:debug"),
//        project(":shared:feature:initialization"),
//        project(":shared:feature:my-requirements"),
//        project(":shared:feature:requirement-filter"),
//        project(":shared:feature:machinery"),
//        project(":shared:feature:user-settings"),
//        project(":shared:generic:database"),
//        project(":shared:generic:debug"),
//        project(":shared:generic:design"),
//        project(":shared:generic:dialog"),
//        project(":shared:generic:image"),
//        project(":shared:generic:network"),
//        project(":shared:generic:requirement"),
//        project(":shared:generic:string"),
//        project(":shared:generic:time"),
//        project(":shared:generic:version"),
//        project(":shared:library:architecture"),
//        project(":shared:library:coroutines"),
//        project(":shared:library:intention"),
//        project(":shared:library:koin-ktx"),
//        project(":shared:library:mvvm"),
    )

    explicitApi()

    iosAll {
        binaries.framework {
            baseName = "Multiplatform"
            linkerOpts.add("-lsqlite3")
            projectDependencies.forEach { export(it) }
            export(Dependency.Koin.core(targetName))
            export(Dependency.DateTime.core(targetName))
        }
    }

    sourceSets {
        named("iosMain") {
            dependencies {
                projectDependencies.forEach { api(it) }
                api(Dependency.Koin.core)
                api(Dependency.DateTime.core)
            }
        }
    }

    configurations.all {
        resolutionStrategy {
            force(Dependency.Coroutines.core)
        }
    }
}