plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "uz.zamin.domain"
}

dependencies {
    implementation(project(":modules:core"))
    // DI
    implementation(libs.bundles.koin)
}
