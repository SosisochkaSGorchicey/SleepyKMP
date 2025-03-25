import com.android.build.gradle.LibraryExtension
import com.buildlogic.configureAndroid
import com.buildlogic.configureKotlinMultiplatformLibrary
import com.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class LibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.kotlin.multiplatform.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatformLibrary)

        extensions.configure<LibraryExtension> {
            configureAndroid(this)

            defaultConfig {
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "consumer-rules.pro"
                    )
                }

                debug {
                    isMinifyEnabled = false
                }
            }
        }
    }
}
