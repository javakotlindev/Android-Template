plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "uz.zamin.data"
}

dependencies {
    implementation(project(":modules:core"))
    implementation(project(":modules:data-source:local"))
    implementation(project(":modules:data-source:remote"))
    implementation(project(":modules:domain"))

    // DI
    implementation(libs.bundles.koin)
}
