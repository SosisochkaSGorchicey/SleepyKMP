import com.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.plugins.convetion.library.get().pluginId)
            apply(libs.plugins.convetion.compose.get().pluginId)
        }

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.apply {
                commonMain.dependencies {
                    implementation(project(":core:domain"))
                    implementation(project(":core:ui"))
                    implementation(project(":core:mvi"))
                    implementation(project(":core:navigation"))
                    implementation(libs.coroutines.core)
                    implementation(libs.koin.core)
                    implementation(libs.voyager.screenmodel)
                    implementation(libs.voyager.koin)
                    implementation(libs.calf.ui)
                }
                iosMain.dependencies {
                    implementation(libs.stately.common)
                }
            }
        }
    }
}
