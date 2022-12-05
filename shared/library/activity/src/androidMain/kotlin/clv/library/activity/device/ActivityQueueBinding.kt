package clv.library.activity.device

import clv.library.activity.device.ActivityEvent.ActivityPause
import clv.library.activity.device.ActivityEvent.ActivityResume
import clv.library.coroutines.infrastructure.ApplicationScope
import kotlinx.coroutines.launch

internal class ActivityQueueBinding(events: ActivityEvents, queue: ActivityQueue) {

    init {
        ApplicationScope.launch {
            events.observe().collect { event ->
                when (event) {
                    is ActivityResume -> queue.resume(event.activity)
                    is ActivityPause -> queue.pause()
                    else -> {
                    }
                }
            }
        }
    }
}
