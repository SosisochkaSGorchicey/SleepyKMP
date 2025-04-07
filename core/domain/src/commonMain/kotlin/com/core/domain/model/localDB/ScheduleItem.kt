package com.core.domain.model.localDB

data class ScheduleItem(
    val id: String = "",
    val createPush: Boolean = true,
    val weekDayId: Int = 1,
    val time: String = "",
    val titleText: String = "",
    val descriptionText: String = ""
) {
    constructor() : this("", true, 1, "", "", "")
}
