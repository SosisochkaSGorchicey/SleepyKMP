plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.convetion.compose)
}

android.namespace = "com.core.ui"

dependencies {
    commonMainImplementation(projects.core.domain)
    commonMainImplementation(projects.core.navigation)

    commonMainImplementation(libs.coroutines.core)
    commonMainImplementation(libs.koin.core)
    commonMainImplementation(libs.calf.ui)
    commonMainImplementation(compose.materialIconsExtended)
    commonMainApi(compose.components.resources)
    commonMainImplementation(libs.compose.shimmer)

    commonMainImplementation(libs.voyager.tab.navigator)
    commonMainImplementation(libs.voyager.transitions)
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.core.ui"
    generateResClass = always
}
