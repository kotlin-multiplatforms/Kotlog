package io.github.kotlinmp.kotlog

expect class Logger {
    companion object {
        val ROOT_LOGGER_NAME: String
    }

    val name: String

    val isDebugEnabled: Boolean
    val isErrorEnabled: Boolean
    val isInfoEnabled: Boolean
    val isTraceEnabled: Boolean
    val isWarnEnabled: Boolean

    fun debug(message: String, throwable: Throwable? = null, vararg arguments: Any?)

    fun error(message: String, throwable: Throwable? = null, vararg arguments: Any?)

    fun info(message: String, throwable: Throwable? = null, vararg arguments: Any?)

    fun trace(message: String, throwable: Throwable? = null, vararg arguments: Any?)

    fun warn(message: String, throwable: Throwable? = null, vararg arguments: Any?)
}

fun Logger.debug(throwable: Throwable? = null, vararg arguments: Any?, message: () -> Any?) {
    if (isDebugEnabled) {
        debug(message().toString(), throwable, arguments)
    }
}

fun Logger.error(throwable: Throwable? = null, vararg arguments: Any?, message: () -> Any?) {
    if (isErrorEnabled) {
        error(message().toString(), throwable, arguments)
    }
}

fun Logger.info(throwable: Throwable? = null, vararg arguments: Any?, message: () -> Any?) {
    if (isInfoEnabled) {
        info(message().toString(), throwable, arguments)
    }
}

fun Logger.trace(throwable: Throwable? = null, vararg arguments: Any?, message: () -> Any?) {
    if (isTraceEnabled) {
        trace(message().toString(), throwable, arguments)
    }
}

fun Logger.warn(throwable: Throwable? = null, vararg arguments: Any?, message: () -> Any?) {
    if (isWarnEnabled) {
        warn(message().toString(), throwable, arguments)
    }
}
