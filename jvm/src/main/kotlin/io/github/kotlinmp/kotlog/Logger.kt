package io.github.kotlinmp.kotlog

import org.slf4j.Logger as Slf4jLogger

actual class Logger private constructor(val backingLogger: Slf4jLogger) {
    actual companion object {
        actual val ROOT_LOGGER_NAME: String = Slf4jLogger.ROOT_LOGGER_NAME

        private val map = mutableMapOf<Slf4jLogger, Logger>()

        operator fun invoke(logger: Slf4jLogger): Logger = map.getOrPut(logger) { Logger(logger) }
    }

    actual val name: String
        get() = backingLogger.name
    actual val isDebugEnabled: Boolean
        get() = backingLogger.isDebugEnabled
    actual val isErrorEnabled: Boolean
        get() = backingLogger.isErrorEnabled
    actual val isInfoEnabled: Boolean
        get() = backingLogger.isInfoEnabled
    actual val isTraceEnabled: Boolean
        get() = backingLogger.isTraceEnabled
    actual val isWarnEnabled: Boolean
        get() = backingLogger.isWarnEnabled

    actual fun debug(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                backingLogger.debug(message.format(*arguments), throwable)
            } else {
                backingLogger.debug(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                backingLogger.debug(message, *arguments)
            } else {
                backingLogger.debug(message)
            }
        }
    }

    actual fun error(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                backingLogger.error(message.format(*arguments), throwable)
            } else {
                backingLogger.error(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                backingLogger.error(message, *arguments)
            } else {
                backingLogger.error(message)
            }
        }
    }

    actual fun info(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                backingLogger.info(message.format(*arguments), throwable)
            } else {
                backingLogger.info(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                backingLogger.info(message, *arguments)
            } else {
                backingLogger.info(message)
            }
        }
    }

    actual fun trace(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                backingLogger.trace(message.format(*arguments), throwable)
            } else {
                backingLogger.trace(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                backingLogger.trace(message, *arguments)
            } else {
                backingLogger.trace(message)
            }
        }
    }

    actual fun warn(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                backingLogger.warn(message.format(*arguments), throwable)
            } else {
                backingLogger.warn(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                backingLogger.warn(message, *arguments)
            } else {
                backingLogger.warn(message)
            }
        }
    }

}
