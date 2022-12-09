package clv.library.mvvm.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

@Suppress("EmptyDefaultConstructor", "UnnecessaryAbstractClass")
public actual abstract class PlatformViewModel actual constructor() {

    protected actual val viewModelScope: CoroutineScope = CoroutineScope(
        context = SupervisorJob() + Dispatchers.Main.immediate,
    )

    public fun clear() {
        viewModelScope.cancel()
    }
}
