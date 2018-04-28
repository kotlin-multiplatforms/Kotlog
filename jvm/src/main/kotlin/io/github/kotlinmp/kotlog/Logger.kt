package io.github.kotlinmp.kotlog

import org.slf4j.Logger as Slf4jLogger

actual class Logger private constructor(private val logger: Slf4jLogger) {
    actual companion object {
        actual val ROOT_LOGGER_NAME: String = Slf4jLogger.ROOT_LOGGER_NAME

        private val map = mutableMapOf<Slf4jLogger, Logger>()

        operator fun invoke(logger: Slf4jLogger): Logger = map.getOrPut(logger) { Logger(logger) }
    }

    actual val name: String
        get() = logger.name
    actual val isDebugEnabled: Boolean
        get() = logger.isDebugEnabled
    actual val isErrorEnabled: Boolean
        get() = logger.isErrorEnabled
    actual val isInfoEnabled: Boolean
        get() = logger.isInfoEnabled
    actual val isTraceEnabled: Boolean
        get() = logger.isTraceEnabled
    actual val isWarnEnabled: Boolean
        get() = logger.isWarnEnabled

    actual fun debug(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                logger.debug(message, throwable, arguments)
            } else {
                logger.debug(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                logger.debug(message, arguments)
            } else {
                logger.debug(message)
            }
        }
    }

    actual fun error(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                logger.error(message, throwable, arguments)
            } else {
                logger.error(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                logger.error(message, arguments)
            } else {
                logger.error(message)
            }
        }
    }

    actual fun info(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                logger.info(message, throwable, arguments)
            } else {
                logger.info(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                logger.info(message, arguments)
            } else {
                logger.info(message)
            }
        }
    }

    actual fun trace(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                logger.trace(message, throwable, arguments)
            } else {
                logger.trace(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                logger.trace(message, arguments)
            } else {
                logger.trace(message)
            }
        }
    }

    actual fun warn(message: String, throwable: Throwable?, vararg arguments: Any?) {
        if (throwable != null) {
            if (arguments.isEmpty()) {
                logger.warn(message, throwable, arguments)
            } else {
                logger.warn(message, throwable)
            }
        } else {
            if (arguments.isEmpty()) {
                logger.warn(message, arguments)
            } else {
                logger.warn(message)
            }
        }
    }

}
