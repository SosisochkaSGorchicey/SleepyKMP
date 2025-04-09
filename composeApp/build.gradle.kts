plugins {
    alias(libs.plugins.convetion.application)
    alias(libs.plugins.convetion.compose)
}

android {
    namespace = "com.alisa.sleepy.kmp"
    defaultConfig {
        applicationId = "com.alisa.sleepy.kmp"
    }
}

dependencies {
    commonMainImplementation(projects.core.domain)
    commonMainImplementation(projects.core.data)
    commonMainImplementation(projects.core.ui)
    commonMainImplementation(projects.core.mvi)
    commonMainImplementation(projects.core.common)
    commonMainImplementation(projects.core.navigation)

    commonMainImplementation(projects.feature.initial)
    commonMainImplementation(projects.feature.auth)

    commonMainImplementation(libs.coroutines.core)
    commonMainImplementation(libs.koin.core)
    commonMainImplementation(libs.koin.compose)
    commonMainImplementation(libs.voyager.navigator)
    commonMainImplementation(libs.voyager.tab.navigator)
    commonMainImplementation(libs.voyager.koin)
    commonMainImplementation(libs.voyager.transitions)

    commonMainImplementation(compose.materialIconsExtended)

    androidMainImplementation(libs.activity.compose)
    androidMainImplementation(libs.androidx.appcompat)
    androidMainImplementation(libs.koin.android)

    iosMainImplementation(libs.stately.common)
}
