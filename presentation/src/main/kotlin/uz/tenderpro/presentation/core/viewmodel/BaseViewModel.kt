package uz.tenderpro.presentation.core.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import uz.tenderpro.core.base.launchUI
import uz.tenderpro.core.base.withUIContext
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<STATE, EVENT, EFFECT>(initialState: STATE) : ViewModel(),
    CoroutineScope {

    private val errorHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }

    override val coroutineContext: CoroutineContext =
        SupervisorJob() + Dispatchers.Main.immediate + errorHandler


    private fun handleError(throwable: Throwable) {
        Log.e("BaseViewModel", "handleError: ", throwable)
    }

    // Get Current State
    val currentState: STATE
        get() = uiState.value

    private val _uiState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _effect: Channel<EFFECT> = Channel()
    val effect = _effect.receiveAsFlow()

    suspend fun postSideEffect(sideEffect: EFFECT) =
        coroutineScope { launchUI { _effect.send(sideEffect) } }

    suspend fun reduceState(block: (STATE) -> STATE) = withUIContext {
        _uiState.update(block)
    }

    fun sendEvent(event: EVENT) = onEvent(event)

    protected abstract fun onEvent(event: EVENT)

}