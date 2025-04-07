import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.build.config)
    alias(libs.plugins.kotlin.serialization)
}

android.namespace = "com.core.data"

dependencies {
    commonMainImplementation(projects.core.domain)
    commonMainImplementation(projects.core.common)

    commonMainImplementation(libs.coroutines.core)
    commonMainImplementation(libs.koin.core)
    commonMainImplementation(libs.multiplatform.settings.common)
    commonMainImplementation(libs.multiplatform.settings.coroutines)

    androidMainImplementation(libs.androidx.appcompat)

    commonMainImplementation(libs.sqlDelight.coroutines)
    commonMainImplementation(libs.kotlinx.datetime)

    commonMainImplementation(libs.supabase.gotrue)
    commonMainImplementation(libs.supabase.postgrest)
    androidMainImplementation(libs.ktor.client.okhttp)
    iosMainImplementation(libs.ktor.client.darwin)
}

private val keystorePropertiesFile = file("keys.properties")
private val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

buildConfig { //todo?
    buildConfigField(
        "SUPABASE_URL",
        keystoreProperties.getProperty("supabaseUrl")
    )
    buildConfigField(
        "SUPABASE_KEY_SECRET",
        keystoreProperties.getProperty("supabaseSecretKey")
    )
}