package clv.library.activity.device

import android.app.Activity
import clv.library.coroutines.infrastructure.ApplicationScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

public interface ActivityEventsSource {
    public fun observe(): SharedFlow<ActivityEvent>
}

internal interface ActivityEventsSink {
    fun emit(event: ActivityEvent)
}

internal class ActivityEvents : ActivityEventsSource, ActivityEventsSink {

    private val eventsChannel = MutableSharedFlow<ActivityEvent>()

    override fun emit(event: ActivityEvent) {
        ApplicationScope.launch {
            eventsChannel.emit(event)
        }
    }

    override fun observe(): SharedFlow<ActivityEvent> = eventsChannel
}

public sealed class ActivityEvent {

    public data class ActivityResume(val activity: Activity) : ActivityEvent()
    public data class ActivityPause(val activity: Activity) : ActivityEvent()
    public data class RequestPermissionsResult(
        val requestCode: Int,
        val permissions: List<String>,
        val grantResults: List<Int>,
    ) : ActivityEvent()
}
