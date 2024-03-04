plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "uz.tenderpro.remote"
}

dependencies {
    implementation(project(":common"))
    // Network
    implementation(libs.bundles.ktor)
    // DI
    implementation(libs.koin.android)
}
