plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "uz.tenderpro.presentation"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose.versions.compiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))
    // Compose
    implementation(platform(compose.bom))
    implementation(compose.activity)
    implementation(compose.foundation)
    // ********Choose material***********
    // Material 3
    implementation(compose.material3.core)
    implementation(compose.material3.adapter)
    // Or Material 2
    // **********************************
    implementation(compose.animation)
    implementation(compose.animation.graphics)
    implementation(compose.ui.tooling)
    implementation(compose.ui.util)
    implementation(compose.accompanist.webview)
    implementation(compose.accompanist.permissions)
    implementation(androidx.paging.compose)

    // AndroidX libraries
    implementation(androidx.annotation)
    implementation(androidx.appcompat)
    implementation(androidx.corektx)
    implementation(androidx.splashscreen)

    implementation(androidx.bundles.lifecycle)

    // Image loading
    implementation(libs.bundles.coil)

    // UI libraries
    implementation(libs.material)
    implementation(libs.bundles.voyager)

    // DI
    implementation(libs.bundles.koin)

    // For detecting memory leaks; see https://square.github.io/leakcanary/
    debugImplementation(libs.leakcanary.android)
    implementation(libs.leakcanary.plumber)
}
