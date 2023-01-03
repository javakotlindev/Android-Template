plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    namespace = "uz.zamin.core"
}

dependencies {
    // Coroutines
    api(platform(androidx.coroutines.bom))
    api(androidx.bundles.coroutines)

    // Logging
    api(libs.logcat)

    // Paging
    api(androidx.paging.runtime)
    api(androidx.bundles.lifecycle)
}
