plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.convetion.compose)
}

android.namespace = "com.core.mvi"

dependencies {
    commonMainApi(libs.voyager.screenmodel)
    commonMainApi(libs.orbit.core)
    commonMainImplementation(libs.coroutines.core)
}
