import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

val versionProperties = loadProperties("$rootDir/versions.properties")

android {
    namespace = "uz.zamin.smartbank"

    defaultConfig {
        applicationId = "uz.zamin.smartbank"
        versionCode = versionProperties.getProperty("versionCode").toInt()
        versionName = versionProperties.getProperty("versionName")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("debug") {
            applicationIdSuffix = ".debug"
        }
        named("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    flavorDimensions += "environment"

    productFlavors {
        create("develop") {
            versionNameSuffix = "-develop"
            applicationIdSuffix = ".develop"
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://logistic.bsl.dev\"")
        }
    }
}

dependencies {
    implementation(project(":modules:data-source:data"))
    implementation(project(":modules:domain"))
    implementation(project(":modules:presentation"))
    implementation(project(":modules:core"))
    implementation(project(":modules:data-source:local"))
    implementation(project(":modules:data-source:remote"))
    // DI
    implementation(libs.koin.android)
}

