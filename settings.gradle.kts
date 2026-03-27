pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/VIZBL/vizbl-android-sdk")
            credentials {
                username = "sane4ekage"
                password = "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"
            }
        }
    }
}

rootProject.name = "Vizbl Demo"
include(":app")
 