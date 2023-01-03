pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("androidx") {
            from(files("gradle/androidx.versions.toml"))
        }
        create("compose") {
            from(files("gradle/compose.versions.toml"))
        }
    }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "SmartBank"
include (":app")
include(":modules:domain")
include(":modules:presentation")
include(":modules:core")
include(":modules:data-source:data")
include(":modules:data-source:local")
include(":modules:data-source:remote")
