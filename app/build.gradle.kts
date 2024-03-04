import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

val versionProperties = loadProperties("$rootDir/versions.properties")

android {
    namespace = "uz.tenderpro"

    defaultConfig {
        applicationId = "uz.tenderpro"
        versionCode = versionProperties.getProperty("versionCode").toInt()
        versionName = versionProperties.getProperty("versionName")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    val currentBranch = getWorkingBranch()
    println("Current branch: $currentBranch")
    val branchData = currentBranch.split('/')
    if (branchData.isEmpty() || !listOf(
            "master",
            "dev/",
            "develop",
            "hotfix/",
            "feature/",
            "bugfix/",
            "release"
        ).any { item -> currentBranch.startsWith(item) }
    ) {
        throw Exception(
            "Incorrect git branch name '$currentBranch'.\n" +
                    "Allowed branch names is: feature, bugfix, hotfix.\n" +
                    "Example: 'feature/{task id}'"
        )
    }

    buildTypes {
        named("debug") {
            applicationIdSuffix = ".debug"
        }
        named("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    flavorDimensions += "environment"

    productFlavors {
        create("develop") {
            versionNameSuffix = "-develop"
            applicationIdSuffix = ".develop"
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://api.m.tender.pro\"")
        }
        create("prod") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://api.m.tender.pro\"")
        }
    }
}

dependencies {
    implementation(project(":data-source:data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))
    implementation(project(":common"))
    implementation(project(":data-source:local"))
    implementation(project(":data-source:remote"))
    // DI
    implementation(libs.koin.android)
}


fun getWorkingBranch(): String {
    var branch = "git rev-parse --abbrev-ref HEAD".runCommand().trim()
    // Fix for gitlab
    if (branch.isEmpty() || branch == "HEAD")
        branch = System.getenv("CI_COMMIT_BRANCH") ?: ""
    if (branch.isEmpty() || branch == "HEAD")
        branch = System.getenv("CI_MERGE_REQUEST_SOURCE_BRANCH_NAME") ?: ""
    return branch
}

fun String.runCommand(workingDir: File = file("./")): String {
    val parts = this.split("\\s".toRegex())
    val proc = ProcessBuilder(*parts.toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()
    proc.waitFor(1, TimeUnit.MINUTES)
    return proc.inputStream.bufferedReader().readText().trim()
}
