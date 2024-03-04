package detekt

import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    detekt("io.gitlab.arturbosch.detekt:detekt-cli:1.23.3")
    detekt("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}

tasks {
    register("openDetektHtmlReportInBrowser") {
        val detektAllTask = tasks.findByName("detektAll") as? Detekt
        onlyIf { detektAllTask?.state?.failure != null }
        doLast {
            val htmlReportPath = detektAllTask?.reports?.html?.outputLocation?.asFile?.get()?.path
            if (htmlReportPath != null) {
                val currentOs = org.gradle.internal.os.OperatingSystem.current()
                val command = if (currentOs.isMacOsX) {
                    listOf("open", htmlReportPath)
                } else if (currentOs.isLinux) {
                    listOf("xdg-open", htmlReportPath)
                } else if (currentOs.isWindows) {
                    listOf("cmd", "/c", "start", htmlReportPath)
                } else {
                    listOf()
                }
                exec { commandLine(command) }
            }
        }
    }
    register("detektAll", Detekt::class) {
        description = "Runs Detekt on the whole project at once."
        parallel = true
        setSource(projectDir)
        include("**/*.kt", "**/*.kts")
        exclude("**/resources/**", "**/build/**")
        config.setFrom(project.file("linters/detekt/config.yml"))
        buildUponDefaultConfig = false
        reports {
            html {
                required.set(true)
                outputLocation.set(file("buildSrc/build/reports/detekt.html"))
            }
        }
        finalizedBy("openDetektHtmlReportInBrowser")
    }
}
