plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "uz.zamin.local"
}

dependencies {
    implementation(project(":modules:core"))

    // Database
    implementation(androidx.bundles.room)
    kapt(androidx.room.compiler)

    // Preferences
    implementation(androidx.datastore.preferences)

    // DI
    implementation(libs.koin.android)
}
