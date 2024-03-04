plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(kotlinLibs.gradle)
    implementation(libraries.detekt.gradle)
    implementation(gradleApi())
}

repositories {
    google()
    mavenCentral()
    maven(url = "https://jitpack.io")
}
