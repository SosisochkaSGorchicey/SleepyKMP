package com.core.domain.usecase.auth

import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import com.core.domain.utils.supabaseRequestFlow
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(
    private val supabaseAuthRepository: SupabaseAuthRepository,
    private val firestoreRepository: FirestoreRepository
) {
    operator fun invoke(
        userName: String,
        email: String,
        password: String
    ): Flow<SupabaseResult<Unit>> = supabaseRequestFlow {
        supabaseAuthRepository.signUp(
            userName = userName,
            email = email,
            password = password
        )
        supabaseAuthRepository.trySaveToken()
        firestoreRepository.createUser(userId = supabaseAuthRepository.getUserId())
    }
}
