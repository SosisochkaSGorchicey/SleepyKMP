package com.core.domain.utils

import kotlinx.datetime.LocalTime

fun LocalTime.toHHtoMM(): String {
    val hour = if (this.hour > 9) this.hour.toString() else "0${this.hour}"
    val minute = if (this.minute > 9) this.minute.toString() else "0${this.minute}"
    return "$hour:$minute"
}

fun String.toLocalTime(): LocalTime {
    val hourText = this.substringBefore(':')
    val hour = if (hourText.startsWith('0')) hourText.substringAfter('0').toInt()
    else hourText.toInt()

    val minuteText = this.substringAfter(':')
    val minute = if (minuteText.startsWith('0')) minuteText.substringAfter('0').toInt()
    else minuteText.toInt()

    return LocalTime(hour = hour, minute = minute, second = 0)
}
