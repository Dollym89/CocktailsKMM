package clv.library.mvvm.presentation

@Suppress("UnnecessaryAbstractClass")
public expect abstract class BaseViewModel<S : ViewModelState>(
    initialState: S,
) : StatefulViewModel<S>
