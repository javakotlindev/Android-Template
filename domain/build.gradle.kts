plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "uz.tenderpro.domain"
}

dependencies {
    implementation(project(":common"))
    // DI
    implementation(libs.bundles.koin)
}
