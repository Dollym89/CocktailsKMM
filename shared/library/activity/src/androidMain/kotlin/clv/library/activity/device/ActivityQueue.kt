package clv.library.activity.device

import android.app.Activity
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference

private typealias Step = (Activity) -> Unit

public class ActivityQueue internal constructor() {

    private val queue = LinkedList<Step>()
    private val currentActivity = AtomicReference<Activity>()
    private var processing = AtomicBoolean(false)

    public fun add(step: Step) {
        queue.add(step)
        processQueue()
    }

    internal fun resume(activity: Activity) {
        currentActivity.set(activity)
        processQueue()
    }

    internal fun pause() {
        currentActivity.clear()
    }

    private fun processQueue() {
        if (currentActivity.exists() && processing.compareAndSet(false, true)) {
            var step: Step?
            while (true) {
                step = queue.poll()
                if (step == null) break
                currentActivity.get()?.apply { step.invoke(this) }
            }
            processing.set(false)
        }
    }
}

private fun AtomicReference<Activity>.clear() = set(null)
private fun AtomicReference<Activity>.exists() = get() != null
