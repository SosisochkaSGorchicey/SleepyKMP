package com.core.ui.utils

import com.core.domain.model.supabase.auth.AuthErrorType
import com.core.ui.Res
import com.core.ui.error
import com.core.ui.error_already_registered
import com.core.ui.error_chain_validation
import com.core.ui.error_email_invalid_format
import com.core.ui.error_invalid_login
import com.core.ui.error_network_connection
import com.core.ui.error_password_invalid_format
import com.core.ui.error_timeout
import com.core.ui.error_unauthorized
import com.core.ui.error_unknown
import org.jetbrains.compose.resources.StringResource

fun AuthErrorType.toTextRes(): StringResource = when (this) {
    AuthErrorType.Timeout -> Res.string.error_timeout
    AuthErrorType.HttpRequest -> Res.string.error_network_connection
    AuthErrorType.ChainValidation -> Res.string.error_chain_validation
    AuthErrorType.UserAlreadyRegistered -> Res.string.error_already_registered
    AuthErrorType.InvalidLoginCredentials -> Res.string.error_invalid_login
    AuthErrorType.InvalidPasswordFormat -> Res.string.error_password_invalid_format
    AuthErrorType.InvalidEmailFormat -> Res.string.error_email_invalid_format
    AuthErrorType.Unauthorized -> Res.string.error_unauthorized
    AuthErrorType.NotFound -> Res.string.error_unknown
    AuthErrorType.Unknown -> Res.string.error_unknown
    AuthErrorType.UserTokenDoesNotExist -> Res.string.error
}
