package clv.library.mvvm.presentation

import clv.library.logger.infrastructure.logD
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach

public abstract class StatefulViewModel<S : ViewModelState>(initialState: S) : PlatformViewModel() {

    private val statesFlow = MutableStateFlow(initialState)

    protected open var state: S
        get() = statesFlow.value
        set(value) {
            statesFlow.value = value
        }

    public open val states: StateFlow<S> = statesFlow.also {
        it.onEach { logD(it) }
    }
}

public interface ViewModelState
