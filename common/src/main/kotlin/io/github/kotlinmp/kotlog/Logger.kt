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
