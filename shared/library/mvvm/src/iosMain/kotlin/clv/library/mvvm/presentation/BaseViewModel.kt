package clv.library.mvvm.presentation

import clv.library.coroutines.domain.SwiftFlow
import clv.library.coroutines.domain.SwiftStateFlow
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

public actual abstract class BaseViewModel<S : ViewModelState> actual constructor(
    initialState: S,
) : StatefulViewModel<S>(initialState) {

    private val changesFlow = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    protected final override var state: S
        get() = super.state
        set(value) {
            changesFlow.tryEmit(Unit)
            super.state = value
        }

    public val changes: SwiftFlow<Unit> = SwiftFlow(changesFlow)

    final override val states: SwiftStateFlow<S> = SwiftStateFlow(super.states)
}
