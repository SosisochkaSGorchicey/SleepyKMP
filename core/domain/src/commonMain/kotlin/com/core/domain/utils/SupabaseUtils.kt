package com.core.domain.utils

import com.core.domain.model.supabase.SupabaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> supabaseRequestFlow(block: suspend () -> T): Flow<SupabaseResult<T>> = flow {
    emit(SupabaseResult.Loading)
    try {
        val result = block()
        emit(SupabaseResult.Success(result))
    } catch (e: Throwable) {
        println("TAG: supabaseRequestFlow e $e")
        emit(e.toSupabaseError())
    }
}
