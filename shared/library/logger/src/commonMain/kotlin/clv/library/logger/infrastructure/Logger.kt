package clv.library.logger.infrastructure

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
public object Logger {

    internal var prefix: String = ""
    internal var writer: Writer = PlainWriter

    public fun initialize(writer: Writer, prefix: String = "") {
        this.prefix = prefix
        this.writer = writer
    }

    public interface Writer {
        public fun logV(tag: String, subject: Any)
        public fun logD(tag: String, subject: Any)
        public fun logI(tag: String, subject: Any)
        public fun logW(tag: String, subject: Any)
        public fun logE(tag: String, subject: Any)
    }

    private object PlainWriter : Writer {
        override fun logV(tag: String, subject: Any) = Unit
        override fun logD(tag: String, subject: Any) = Unit
        override fun logI(tag: String, subject: Any) = Unit
        override fun logW(tag: String, subject: Any) = Unit
        override fun logE(tag: String, subject: Any) = Unit
    }
}

// @formatter:off
public fun <T : Any> T.logV(subject: Any) { Logger.writer.logV(tag(), subject) }
public fun <T : Any> T.logD(subject: Any) { Logger.writer.logD(tag(), subject) }
public fun <T : Any> T.logI(subject: Any) { Logger.writer.logI(tag(), subject) }
public fun <T : Any> T.logW(subject: Any) { Logger.writer.logW(tag(), subject) }
public fun <T : Any> T.logE(subject: Any) { Logger.writer.logE(tag(), subject) }
// @formatter:on

private fun <T : Any> T.tag() = Logger.prefix + this::class.simpleName.orEmpty()
