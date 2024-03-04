import com.android.build.gradle.BaseExtension

buildscript {
    dependencies {
        classpath(libs.google.services.gradle)
        classpath(androidx.serialization.gradle)
        classpath(androidx.gradle)
    }
}

@Suppress("DSL_SCOPE_VIOLATION") plugins {
    alias(androidx.plugins.application) apply false
    alias(androidx.plugins.library) apply false
    alias(androidx.plugins.android) apply false
    id("detekt.plugin")
}

subprojects {
    plugins.applyBaseConfig(project)
}

fun BaseExtension.baseConfig() {
    compileSdkVersion(34)

    defaultConfig.apply {
        minSdk = 23
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
    }
}

fun PluginContainer.applyBaseConfig(project: Project) {
    whenPluginAdded {
        when (this) {
            is com.android.build.gradle.AppPlugin -> {
                project.extensions.getByType<com.android.build.gradle.AppExtension>().apply {
                    baseConfig()
                }
            }

            is com.android.build.gradle.LibraryPlugin -> {
                project.extensions.getByType<com.android.build.gradle.LibraryExtension>().apply {
                    baseConfig()
                }
            }
        }
    }
}

tasks {
    register("setupProject") {
        group = "utils"
        dependsOn("installGitHooks")
    }
    register("installGitHooks", Copy::class) {
        group = "utils"
        description = "Adding githook to local working copy, this must be run manually"
        from("${rootProject.rootDir}/.githooks/pre-commit")
        into("${rootProject.rootDir}/.git/hooks")
        fileMode = 0x755
    }
    register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}
