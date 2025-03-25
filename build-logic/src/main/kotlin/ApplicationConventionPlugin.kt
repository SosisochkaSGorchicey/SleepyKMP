import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.buildlogic.configureAndroid
import com.buildlogic.configureKotlinMultiplatformApplication
import com.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.android.application.get().pluginId)
            apply(libs.plugins.kotlin.multiplatform.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatformApplication)

        extensions.configure<BaseAppModuleExtension> {
            configureAndroid(this)

            defaultConfig {
                targetSdk = libs.versions.targetSdk.get().toInt()
                versionCode = libs.versions.versionCode.get().toInt()
                versionName = libs.versions.versionName.get()
                vectorDrawables.useSupportLibrary = true
            }

            packagingOptions.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"

            sourceSets["main"].apply {
                manifest.srcFile("src/androidMain/AndroidManifest.xml")
                res.srcDirs("src/androidMain/res")
            }

            buildTypes {
                release {
                    signingConfig = signingConfigs.getByName("debug")
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }

                debug {
                    isMinifyEnabled = false
                    isShrinkResources = false
                }
            }
        }
    }
}
