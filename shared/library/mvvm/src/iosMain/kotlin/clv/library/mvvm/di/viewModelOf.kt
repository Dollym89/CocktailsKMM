package clv.library.mvvm.di

import clv.library.mvvm.presentation.PlatformViewModel
import org.koin.core.definition.Definition
import org.koin.core.instance.InstanceFactory
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

public actual inline fun <reified T : PlatformViewModel> Module.viewModel(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): Pair<Module, InstanceFactory<T>> = factory(qualifier, definition)
