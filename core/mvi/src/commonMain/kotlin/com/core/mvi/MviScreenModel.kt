package com.core.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

abstract class MviScreenModel<S : Any, SE : Any, E : Any>(
    initialState: S,
) : ScreenModel, ContainerHost<S, SE> {

    abstract fun onEvent(event: E)

    final override val container = screenModelScope.container<S, SE>(initialState = initialState)

    val state = container.stateFlow
}

@Composable
fun <S : Any, SE : Any, E : Any> MviScreenModel<S, SE, E>.collectSideEffect(
    collector: (suspend (sideEffect: SE) -> Unit),
) {
    val scope = rememberCoroutineScope()
    container.sideEffectFlow.onEach(collector).launchIn(scope)
}
