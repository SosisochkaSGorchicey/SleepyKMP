package com.core.data.repository

import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.FirestoreRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FirestoreRepositoryImpl : FirestoreRepository { //todo all

    private val _scheduleItems: MutableStateFlow<List<ScheduleItem>> = MutableStateFlow(emptyList())
    override val scheduleItems = _scheduleItems.asStateFlow()

    private val scheduleRef = { userId: String ->

    }

    override suspend fun saveSchedule(userId: String, scheduleItem: ScheduleItem) {
    }

    override suspend fun updateSchedule(userId: String, scheduleItem: ScheduleItem) {
    }

    override suspend fun delete(userId: String, scheduleItemId: String) {

    }

    override suspend fun createUser(userId: String) {
    }

    override fun observeScheduleForUser(userId: String) {

    }
}