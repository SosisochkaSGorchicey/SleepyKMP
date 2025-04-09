plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.convetion.compose)
}

android.namespace = "com.core.ui"

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.domain)
            implementation(projects.core.navigation)

            implementation(libs.coroutines.core)
            implementation(libs.koin.core)
            implementation(libs.calf.ui)
            implementation(compose.materialIconsExtended)
            api(compose.components.resources)
            implementation(libs.compose.shimmer)
            implementation(libs.voyager.tab.navigator)
            implementation(libs.voyager.transitions)
            implementation(libs.kotlinx.datetime)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.core.ui"
    generateResClass = always
}
