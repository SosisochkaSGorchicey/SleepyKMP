package com.feature.audioContent.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.navigation.SharedScreen
import com.feature.audioContent.presentation.main.AudioContentScreen
import com.feature.audioContent.presentation.main.screenmodel.AudioContentScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val contentScreenModule = screenModule {
    register<SharedScreen.ContentRoute> {
        AudioContentScreen
    }
}

val contentFeatureModule = module {
    factoryOf(::AudioContentScreenModel)
}