package uz.zamin.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<STATE, EVENT, EFFECT>(initialState: STATE) : ViewModel(),
    CoroutineScope {

    private val errorHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }

    override val coroutineContext: CoroutineContext =
        SupervisorJob() + Dispatchers.Main + errorHandler


    private fun handleError(throwable: Throwable) {
        Log.e("BaseViewModel", "handleError: ", throwable)
    }

    // Get Current State
    val currentState: STATE
        get() = uiState.value

    private val _uiState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private val _event: MutableSharedFlow<EVENT> = MutableSharedFlow()

    private val _effect: Channel<EFFECT> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        _event.onEach { onEvent(it) }.catch { Log.i("error", "${it.message}") }
            .launchIn(viewModelScope)
    }

    suspend fun postSideEffect(sideEffect: EFFECT) =
        coroutineScope { launchUI { _effect.send(sideEffect) } }

    suspend fun reduceState(block: (STATE) -> STATE) = withUIContext {
        _uiState.value = block(uiState.value).also { onChangeState(uiState.value, it) }
    }

    protected fun onChangeState(prevState: STATE, state: STATE) {
        // EMPTY
    }

    fun sendEvent(event: EVENT) = launch { _event.emit(event) }

    protected abstract fun onEvent(event: EVENT)

}