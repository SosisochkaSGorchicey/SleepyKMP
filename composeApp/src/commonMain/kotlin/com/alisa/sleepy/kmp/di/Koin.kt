package com.alisa.sleepy.kmp.di

import com.core.data.di.dataModule
import com.core.domain.di.domainModule
import com.feature.initial.di.initialModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(): KoinApplication = startKoin {
    modules(
        domainModule,
        dataModule,
        initialModule
    )
}
