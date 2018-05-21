package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.styling.BackgroundColor
import io.github.kotlinmp.kotlog.styling.Color
import io.github.kotlinmp.kotlog.styling.ForegroundColor

/**
 * This class defines the type of logs
 */
data class LogType(
    val label: String,
    val foreground: ForegroundColor,
    val background: BackgroundColor,
    val badge: String
) {
    companion object {
        val INFO = LogType("info", Color.BLUE.foreground, Color.UNSET.background, "i")
        val WARN = LogType("warning", Color.YELLOW.foreground, Color.UNSET.background, "⚠")
        val ERROR = LogType("error", Color.RED.foreground, Color.UNSET.background, "✖")
        val DEBUG = LogType("debug", Color.BLUE.foreground, Color.UNSET.background, "●")
        val TRACE = LogType("trace", Color.PURPLE.foreground, Color.UNSET.background, "…")
    }
}

enum class LogLevel {
    OFF,
    INFO,
    WARN,
    ERROR,
    DEBUG,
    TRACE
}

/**
 * This class uses to log some messages.
 */
expect class Logger {
    companion object {
        /**
         * Case insensitive String constant used to retrieve the name of the root logger.
         */
        val ROOT_LOGGER_NAME: String
    }

    /**
     * The name of this logger instance.
     */
    val name: String

    /**
     * Log an message at the DEBUG level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param type The type. it adds the label of
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    fun log(
        level: LogLevel,
        message: String,
        throwable: Throwable? = null,
        type: LogType? = null,
        vararg arguments: Any?
    )

}

/**
 * Log an message at the DEBUG level with an according to the specified format and arguments.
 * If the exception (throwable) is not null, log that with the message.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.debug(
    message: String,
    throwable: Throwable? = null,
    type: LogType? = LogType.DEBUG,
    vararg arguments: Any?
) = log(LogLevel.DEBUG, message, throwable, type, arguments)

/**
 * Log an message at the ERROR level with an according to the specified format and arguments.
 * If the exception (throwable) is not null, log that with the message.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.error(
    message: String,
    throwable: Throwable? = null,
    type: LogType? = LogType.ERROR,
    vararg arguments: Any?
) = log(LogLevel.ERROR, message, throwable, type, arguments)

/**
 * Log an message at the INFO level with an according to the specified format and arguments.
 * If the exception (throwable) is not null, log that with the message.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.info(
    message: String,
    throwable: Throwable? = null,
    type: LogType? = LogType.INFO,
    vararg arguments: Any?
) = log(LogLevel.INFO, message, throwable, type, arguments)

/**
 * Log an message at the TRACE level with an according to the specified format and arguments.
 * If the exception (throwable) is not null, log that with the message.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.trace(
    message: String,
    throwable: Throwable? = null,
    type: LogType? = LogType.TRACE,
    vararg arguments: Any?
) = log(LogLevel.TRACE, message, throwable, type, arguments)

/**
 * Log an message at the WARN level with an according to the specified format and arguments.
 * If the exception (throwable) is not null, log that with the message.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.warn(
    message: String,
    throwable: Throwable? = null,
    type: LogType? = LogType.WARN,
    vararg arguments: Any?
) = log(LogLevel.WARN, message, throwable, type, arguments)

/**
 * This method is similar to [Logger.debug] method except that the message evaluated lazy.
 *
 * @param message The message. If arguments isn't empty, format the message with arguments.
 * @param throwable The exception (throwable) to log.
 * @param arguments The arguments. If it isn't empty, the message is formatted through this.
 */
fun Logger.debug(
    throwable: Throwable? = null,
    type: LogType? = LogType.DEBUG,
    vararg arguments: Any?,
    message: () -> Any?
) =
    debug(message().toString(), throwable, type, arguments)

/**
 * This method is similar to [Logger.error] method except that the message evaluated lazy.
 */
fun Logger.error(
    throwable: Throwable? = null,
    type: LogType? = LogType.ERROR,
    vararg arguments: Any?,
    message: () -> Any?
) =
    error(message().toString(), throwable, type, arguments)

/**
 * This method is similar to [Logger.info] method except that the message evaluated lazy.
 */
fun Logger.info(
    throwable: Throwable? = null,
    type: LogType? = LogType.INFO,
    vararg arguments: Any?,
    message: () -> Any?
) =
    info(message().toString(), throwable, type, arguments)

/**
 * This method is similar to [Logger.trace] method except that the message evaluated lazy.
 */
fun Logger.trace(
    throwable: Throwable? = null,
    type: LogType? = LogType.TRACE,
    vararg arguments: Any?,
    message: () -> Any?
) =
    trace(message().toString(), throwable, type, arguments)

/**
 * This method is similar to [Logger.warn] method except that the message evaluated lazy.
 */
fun Logger.warn(
    throwable: Throwable? = null,
    type: LogType? = LogType.WARN,
    vararg arguments: Any?,
    message: () -> Any?
) =
    warn(message().toString(), throwable, type, arguments)


/**
 * This method is similar to [Logger.error] method except that the message from the throwable
 */
fun Logger.error(
    throwable: Throwable,
    type: LogType? = LogType.ERROR,
    vararg arguments: Any?
) =
    error(
        PlatformDependedFeatures.getErrorName(throwable) + ": " + (throwable.message ?: ""),
        throwable,
        type,
        arguments
    )
