package clv.library.logger.kermit.infrastructure

import clv.library.logger.infrastructure.Logger

public class KermitWriter(private val kermit: co.touchlab.kermit.Logger) : Logger.Writer {
    // @formatter:off
    override fun logV(tag: String, subject: Any) { kermit.withTag(tag).v { subject.toString() } }
    override fun logD(tag: String, subject: Any) { kermit.withTag(tag).d { subject.toString() } }
    override fun logI(tag: String, subject: Any) { kermit.withTag(tag).i { subject.toString() } }
    override fun logW(tag: String, subject: Any) { kermit.withTag(tag).w { subject.toString() } }
    override fun logE(tag: String, subject: Any) { kermit.withTag(tag).e { subject.toString() } }
    // @formatter:on
}
