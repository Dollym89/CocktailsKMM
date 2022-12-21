package clv.library.architecture.infrastructure

import clv.library.architecture.domain.UiDispatcher
import kotlinx.coroutines.CoroutineDispatcher

public actual val ApplicationDispatcher: CoroutineDispatcher = UiDispatcher
