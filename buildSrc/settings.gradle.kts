dependencyResolutionManagement {
    versionCatalogs {
        create("libraries") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("kotlinLibs") {
            from(files("../gradle/androidx.versions.toml"))
        }
    }
}
