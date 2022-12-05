package clv.library.activity.device

import android.app.Activity
import io.mockk.Called
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.Test

private typealias Step = (Activity) -> Unit

internal class ActivityQueueTest {

    private val step1 = anyStep()
    private val step2 = anyStep()
    private val step3 = anyStep()
    private val queue = ActivityQueue()

    @Test
    fun `processing should be disabled by default`() {
        queue.add(step1)

        verify(inverse = true) { step1.invoke(any()) }
    }

    @Test
    fun `processing should be enabled when activity is resumed`() {
        val activity = anyActivity()

        queue.resume(activity)
        queue.add(step1)

        verify { step1.invoke(activity) }
    }

    @Test
    fun `processing should be disabled when activity is paused`() {
        val activity = anyActivity()

        queue.resume(activity)
        queue.pause()
        queue.add(step1)

        verify(inverse = true) { step1.invoke(any()) }
    }

    @Test
    fun `steps added before activity is resumed should be processed when activity is resumed`() {
        val activity = anyActivity()

        queue.add(step1)
        queue.resume(activity)

        verify { step1.invoke(activity) }
    }

    @Test
    fun `steps should be processed in order as added`() {
        queue.add(step1)
        queue.resume(anyActivity())
        queue.add(step2)
        queue.pause()
        queue.resume(anyActivity())
        queue.add(step3)

        verifyOrder {
            step1.invoke(any())
            step2.invoke(any())
            step3.invoke(any())
        }
    }

    @Test
    fun `processing of step that adds another step shouldn't start parallel processing`() {
        val newStep = anyStep()
        val stepThatAddsStep = spyk(StepThatAddsAnotherSteps(newStep))

        queue.resume(anyActivity())
        queue.add(stepThatAddsStep)

        verify { stepThatAddsStep.invoke(any()) }
        verify { newStep.invoke(any()) }
    }

    @Test
    fun `step added by another step should be processed as last`() {
        val newStep = anyStep()
        val stepThatAddsStep = spyk(StepThatAddsAnotherSteps(newStep))

        queue.resume(anyActivity())
        queue.add(stepThatAddsStep)

        verifyOrder {
            stepThatAddsStep.invoke(any())
            newStep.invoke(any())
        }
    }

    @Test
    fun `stress test of dynamically modified step queue`() {
        val stepThatAddsStep1 = spyk(StepThatAddsAnotherSteps(step1))
        val stepAfterStepThatAddsStep1BeforeActivityResumedSoExecutedBeforeStep1 = anyStep()
        val stepThatAddsStep2and3 = spyk(StepThatAddsAnotherSteps(step2, step3))

        queue.add(stepThatAddsStep1)
        queue.add(stepAfterStepThatAddsStep1BeforeActivityResumedSoExecutedBeforeStep1)
        queue.resume(anyActivity())
        queue.add(stepThatAddsStep2and3)

        verifyOrder {
            stepThatAddsStep1.invoke(any())
            stepAfterStepThatAddsStep1BeforeActivityResumedSoExecutedBeforeStep1.invoke(any())
            step1.invoke(any())
            stepThatAddsStep2and3.invoke(any())
            step2.invoke(any())
            step3.invoke(any())
        }
    }

    @Test
    fun `when step pauses an activity other steps should be ignored`() {
        queue.add(step1)
        queue.add(StepThatPausesActivity())
        queue.add(step2)
        queue.add(step3)

        queue.resume(anyActivity())

        verify { step1.invoke(any()) }
        verify { step2 wasNot Called }
        verify { step3 wasNot Called }
    }

    private fun anyActivity() = mockk<Activity>()
    private fun anyStep() = mockk<Step>(relaxed = true)

    private open inner class StepThatAddsAnotherSteps(private vararg val newSteps: Step) : Step {
        override fun invoke(activity: Activity) {
            newSteps.forEach { step ->
                queue.add(step)
                verify(inverse = true) { step.invoke(any()) }
            }
        }
    }

    private inner class StepThatPausesActivity : Step {
        override fun invoke(activity: Activity) {
            queue.pause()
        }
    }
}
