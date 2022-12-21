package clv.library.architecture.infrastructure

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

public actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default
