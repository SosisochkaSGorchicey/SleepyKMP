plugins {
    `kotlin-dsl`
}

group = "com.build.logic"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.compose.gradle.plugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("application") {
            id = "convention.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("library") {
            id = "convention.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("feature") {
            id = "convention.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("compose") {
            id = "convention.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}
