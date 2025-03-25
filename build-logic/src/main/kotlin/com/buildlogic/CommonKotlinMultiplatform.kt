package com.buildlogic

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun configureKotlinMultiplatformApplication(extension: KotlinMultiplatformExtension) =
    with(extension) {

        applyDefaultHierarchyTemplate()

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "ComposeApp"
                isStatic = true
                binaryOption("bundleId", "com.alisa.sleepy.kmp")
            }
        }

        androidTarget {
            compilations.all {
                kotlinOptions {
                    jvmTarget = "${JavaVersion.VERSION_17}"
                }
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_17}")
                }
            }
        }

        targets.configureEach {
            compilations.configureEach {
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }
            }
        }
    }

internal fun configureKotlinMultiplatformLibrary(extension: KotlinMultiplatformExtension) =
    with(extension) {

        applyDefaultHierarchyTemplate()

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = project.name
                isStatic = true
            }
        }

        androidTarget {
            compilations.all {
                kotlinOptions {
                    jvmTarget = "${JavaVersion.VERSION_17}"
                }
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xjdk-release=${JavaVersion.VERSION_17}")
                }
            }
        }

        targets.all {
            compilations.all {
                compilerOptions.configure {
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }
            }
        }
    }
