plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "uz.tenderpro.data"
}

dependencies {
    implementation(project(":common"))
    implementation(project(":data-source:local"))
    implementation(project(":data-source:remote"))
    implementation(project(":domain"))

    // DI
    implementation(libs.bundles.koin)
}
