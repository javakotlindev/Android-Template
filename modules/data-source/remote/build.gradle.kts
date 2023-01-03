plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "uz.zamin.remote"
}

dependencies {
    implementation(project(":modules:core"))
    //implementation(project(":core-di"))

    // Network
    implementation(libs.bundles.ktor)

    // DI
    implementation(libs.koin.android)
}
