package com.feature.home.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.domain.model.supabase.auth.AuthErrorType
import com.core.ui.Res
import com.core.ui.error_chain_validation
import com.core.ui.error_network_connection
import com.core.ui.error_timeout
import com.core.ui.error_unknown
import org.jetbrains.compose.resources.StringResource


fun AuthErrorType.toTextRes(): StringResource = when (this) {
    AuthErrorType.Timeout -> Res.string.error_timeout
    AuthErrorType.HttpRequest -> Res.string.error_network_connection
    AuthErrorType.ChainValidation -> Res.string.error_chain_validation
    else -> Res.string.error_unknown
}

fun Int.toPadding(lastIndex: Int): Modifier =
    when (this) {
        0 -> Modifier.padding(start = 10.dp)
        lastIndex -> Modifier.padding(end = 10.dp)
        else -> Modifier
    }
