package com.feature.audioContent.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.navigation.SharedScreen
import com.feature.audioContent.presentation.detail.DetailsScreen
import com.feature.audioContent.presentation.detail.screenmodel.PlayerDetailsScreenModel
import com.feature.audioContent.presentation.detail.service.MusicServiceHandler
import com.feature.audioContent.presentation.main.AudioContentScreen
import com.feature.audioContent.presentation.main.screenmodel.AudioContentScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val contentScreenModule = screenModule {
    register<SharedScreen.ContentRoute> {
        AudioContentScreen
    }

    register<SharedScreen.PlayerDetailScreen> {
        DetailsScreen(
            imageRes = it.audioDataItem.imageRes,
            audioUrl = it.audioDataItem.audioUrl,
            name = it.audioDataItem.name,
            tag = it.audioDataItem.tag,
            minutesDuration = it.audioDataItem.minutesDuration
        )
    }
}

val contentFeatureModule = module {
    factoryOf(::AudioContentScreenModel)
    factoryOf(::PlayerDetailsScreenModel)

    singleOf(::MusicServiceHandler)
}
