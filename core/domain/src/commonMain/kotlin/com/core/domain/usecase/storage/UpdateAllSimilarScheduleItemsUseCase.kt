package com.core.domain.usecase.storage

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import kotlinx.coroutines.flow.first

class UpdateAllSimilarScheduleItemsUseCase(
    private val firestoreRepository: FirestoreRepository,
    private val supabaseAuthRepository: SupabaseAuthRepository
) {
    suspend operator fun invoke(
        oldScheduleItem: ScheduleItem,
        updatedScheduleItem: ScheduleItem,
    ) {
        val userId = supabaseAuthRepository.getUserId()
        val items = firestoreRepository.scheduleItems.first()

        items
            .filter {
                it.createPush == oldScheduleItem.createPush &&
                        it.titleText == oldScheduleItem.titleText &&
                        it.descriptionText == oldScheduleItem.descriptionText &&
                        it.time == oldScheduleItem.time
            }.forEach { item ->
                firestoreRepository.updateSchedule(
                    userId = userId,
                    scheduleItem = item.copy(
                        createPush = updatedScheduleItem.createPush,
                        time = updatedScheduleItem.time,
                        titleText = updatedScheduleItem.titleText,
                        descriptionText = updatedScheduleItem.descriptionText
                    )
                )
            }
    }
}
