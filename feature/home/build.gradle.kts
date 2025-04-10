plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.home"

dependencies {
    commonMainImplementation(libs.coil.compose)
    commonMainImplementation(libs.coil.network.ktor)
}
