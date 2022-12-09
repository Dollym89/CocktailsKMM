package clv.library.mvvm.presentation

import kotlinx.coroutines.CoroutineScope

@Suppress("EmptyDefaultConstructor", "UnnecessaryAbstractClass")
public expect abstract class PlatformViewModel constructor() {

    protected val viewModelScope: CoroutineScope
}
