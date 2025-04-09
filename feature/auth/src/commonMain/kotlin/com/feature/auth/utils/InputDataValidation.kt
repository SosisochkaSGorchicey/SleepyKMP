package com.feature.auth.utils

import com.core.ui.Res
import com.core.ui.error_email_invalid_format
import com.core.ui.error_empty_field
import com.core.ui.error_name_length
import com.core.ui.error_password_length
import org.jetbrains.compose.resources.StringResource


private val emailRegex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

fun emailIsValid(email: String): StringResource? = when {
    (email.isBlank() || email.isEmpty()) -> Res.string.error_empty_field
    !email.matches(emailRegex) -> Res.string.error_email_invalid_format
    else -> null
}

fun passwordIsValid(password: String): StringResource? = when {
    (password.isEmpty() || password.isBlank()) -> Res.string.error_empty_field
    (password.length < 6) -> Res.string.error_password_length
    else -> null
}

fun nameIsValid(name: String): StringResource? = when {
    (name.isEmpty() || name.isBlank()) -> Res.string.error_empty_field
    (name.length > 30) -> Res.string.error_name_length
    else -> null
}
