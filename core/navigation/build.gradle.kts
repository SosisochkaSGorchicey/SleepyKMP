plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

android.namespace = "com.core.navigation"

dependencies {
    commonMainImplementation(projects.core.ui)
    commonMainImplementation(libs.voyager.navigator)
    commonMainImplementation(libs.voyager.tab.navigator)
    commonMainImplementation(compose.runtime)
    commonMainImplementation(compose.runtimeSaveable)
    commonMainImplementation(compose.uiUtil)
    commonMainImplementation(compose.ui)
    commonMainImplementation(compose.material3)
    commonMainImplementation(compose.material)
}
