package clv.library.activity.di

import clv.library.activity.device.ActivityEvents
import clv.library.activity.device.ActivityEventsSink
import clv.library.activity.device.ActivityEventsSource
import clv.library.activity.device.ActivityQueue
import clv.library.activity.device.ActivityQueueBinding
import clv.library.activity.system.EventsActivityDelegate
import clv.library.koin.di.factoryOf
import clv.library.koin.di.singleOf
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

public actual val activityModule: Module = module {
    singleOf(::ActivityQueueBinding, createdAtStart = true)
    singleOf(::ActivityQueue)
    singleOf(::ActivityEvents) binds arrayOf(
        ActivityEventsSource::class,
        ActivityEventsSink::class,
    )
    factoryOf(::EventsActivityDelegate)
}
