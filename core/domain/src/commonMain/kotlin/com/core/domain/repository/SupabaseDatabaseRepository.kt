package com.core.domain.repository

import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.model.supabase.db.ArticleItem
import com.core.domain.model.supabase.db.AudioSection
import com.core.domain.model.supabase.db.StoryItem
import kotlinx.coroutines.flow.Flow

interface SupabaseDatabaseRepository {
    suspend fun stories(): Flow<SupabaseResult<List<StoryItem>>>
    suspend fun articles(): Flow<SupabaseResult<List<ArticleItem>>>
    suspend fun audioSections(): Flow<SupabaseResult<List<AudioSection>>>
}
