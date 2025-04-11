plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.audioContent"

dependencies {
    //implementation(projects.feature.player) todo
    commonMainImplementation(libs.coil.compose)
    commonMainImplementation(libs.coil.network.ktor)
}
