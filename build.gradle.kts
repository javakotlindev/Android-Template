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
}

subprojects {
    plugins.applyBaseConfig(project)
}

fun BaseExtension.baseConfig() {
    compileSdkVersion(33)

    defaultConfig.apply {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
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
    register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}
