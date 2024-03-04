plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "uz.tenderpro.local"
}

dependencies {
    implementation(project(":common"))

    // Database
    implementation(androidx.bundles.room)
    kapt(androidx.room.compiler)

    // Preferences
    implementation(androidx.datastore.preferences)

    // DI
    implementation(libs.koin.android)
}
