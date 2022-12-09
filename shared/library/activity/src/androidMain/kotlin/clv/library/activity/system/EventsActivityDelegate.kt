package clv.library.activity.system

import android.app.Activity
import clv.library.activity.device.ActivityEvent.ActivityPause
import clv.library.activity.device.ActivityEvent.ActivityResume
import clv.library.activity.device.ActivityEvent.RequestPermissionsResult
import clv.library.activity.device.ActivityEventsSink

public class EventsActivityDelegate internal constructor(
    private val events: ActivityEventsSink,
) {

    public fun onResume(activity: Activity) {
        events.emit(ActivityResume(activity))
    }

    public fun onPause(activity: Activity) {
        events.emit(ActivityPause(activity))
    }

    public fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        events.emit(
            RequestPermissionsResult(
                requestCode = requestCode,
                permissions = permissions.toList(),
                grantResults = grantResults.toList(),
            ),
        )
    }
}
