package clv.library.mvvm.presentation

import kotlinx.coroutines.flow.StateFlow

public actual abstract class BaseViewModel<S : ViewModelState> actual constructor(
    initialState: S,
) : StatefulViewModel<S>(initialState) {

    protected final override var state: S
        get() = super.state
        set(value) {
            super.state = value
        }

    final override val states: StateFlow<S> = super.states
}
