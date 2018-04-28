package io.github.kotlinmp.kotlog

actual class Logger {
    actual companion object {
        actual val ROOT_LOGGER_NAME: String
            get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual val name: String
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    actual val isDebugEnabled: Boolean
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    actual val isErrorEnabled: Boolean
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    actual val isInfoEnabled: Boolean
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    actual val isTraceEnabled: Boolean
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    actual val isWarnEnabled: Boolean
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    actual fun debug(message: String, throwable: Throwable?, vararg arguments: Any?) {}
    actual fun error(message: String, throwable: Throwable?, vararg arguments: Any?) {}
    actual fun info(message: String, throwable: Throwable?, vararg arguments: Any?) {}
    actual fun trace(message: String, throwable: Throwable?, vararg arguments: Any?) {}
    actual fun warn(message: String, throwable: Throwable?, vararg arguments: Any?) {}

}
