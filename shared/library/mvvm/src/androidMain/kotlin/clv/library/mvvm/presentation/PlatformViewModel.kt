package clv.library.mvvm.presentation

import androidx.lifecycle.viewModelScope as androidViewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope

@Suppress("EmptyDefaultConstructor")
public actual abstract class PlatformViewModel actual constructor() : ViewModel() {

    protected actual val viewModelScope: CoroutineScope = androidViewModelScope
}
