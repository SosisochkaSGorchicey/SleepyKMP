package com.core.domain.repository

import com.core.domain.model.localDB.ScheduleItem
import kotlinx.coroutines.flow.SharedFlow

interface FirestoreRepository {

    val scheduleItems: SharedFlow<List<ScheduleItem>>

    suspend fun saveSchedule(userId: String, scheduleItem: ScheduleItem)
    suspend fun updateSchedule(userId: String, scheduleItem: ScheduleItem)
    suspend fun delete(userId: String, scheduleItemId: String)
    suspend fun createUser(userId: String)

    fun observeScheduleForUser(userId: String)
}
