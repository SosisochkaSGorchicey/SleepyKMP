package com.core.data.di

import SleepyKMP.core.data.BuildConfig
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.FlowType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    single { Settings() as ObservableSettings }

    singleOf(::provideSupabaseClient)
    singleOf(::provideSupabaseAuth)
    singleOf(::provideSupabasePostgrest)
}

private fun provideSupabaseClient(): SupabaseClient {
    return createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_KEY_SECRET
    ) {
        install(Auth) {
            flowType = FlowType.PKCE
            scheme = "app"
            host = "supabase.com"
            autoSaveToStorage = true
            autoLoadFromStorage = true
            alwaysAutoRefresh = true
        }
        install(Postgrest)
    }
}

private fun provideSupabaseAuth(client: SupabaseClient): Auth = client.auth
private fun provideSupabasePostgrest(client: SupabaseClient): Postgrest = client.postgrest