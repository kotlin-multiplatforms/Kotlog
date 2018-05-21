package io.github.kotlinmp.kotlog.compat

import io.github.kotlinmp.kotlog.*

class CompatLogger(val logger: Logger) {

    /**
     * The name of this logger instance.
     */
    val name: String
        get() = logger.name

    /**
     * Log an message at the DEBUG level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param type The type. it adds the label of
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun log(
        level: LogLevel,
        message: String,
        throwable: Throwable? = null,
        type: LogType? = null,
        vararg arguments: Any?
    ) = logger.log(level, message, throwable, type, *arguments)

    /**
     * Log an message at the DEBUG level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun debug(
        message: String,
        throwable: Throwable? = null,
        type: LogType? = LogType.DEBUG,
        vararg arguments: Any?
    ) = logger.debug(message, throwable, type, *arguments)

    /**
     * Log an message at the ERROR level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun error(
        message: String,
        throwable: Throwable? = null,
        type: LogType? = LogType.ERROR,
        vararg arguments: Any?
    ) = logger.error(message, throwable, type, *arguments)

    /**
     * Log an message at the INFO level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun info(
        message: String,
        throwable: Throwable? = null,
        type: LogType? = LogType.INFO,
        vararg arguments: Any?
    ) = logger.info(message, throwable, type, *arguments)

    /**
     * Log an message at the TRACE level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun trace(
        message: String,
        throwable: Throwable? = null,
        type: LogType? = LogType.TRACE,
        vararg arguments: Any?
    ) = logger.trace(message, throwable, type, *arguments)

    /**
     * Log an message at the WARN level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun warn(
        message: String,
        throwable: Throwable? = null,
        type: LogType? = LogType.WARN,
        vararg arguments: Any?
    ) = logger.warn(message, throwable, type, *arguments)

    /**
     * This method is similar to [Logger.debug] method except that the message evaluated lazy.
     *
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    @JvmOverloads
    fun debug(
        throwable: Throwable? = null,
        type: LogType? = LogType.DEBUG,
        vararg arguments: Any?,
        message: () -> Any?
    ) = logger.debug(throwable, type, *arguments, message = message)

    /**
     * This method is similar to [Logger.error] method except that the message evaluated lazy.
     */
    @JvmOverloads
    fun error(
        throwable: Throwable? = null,
        type: LogType? = LogType.ERROR,
        vararg arguments: Any?,
        message: () -> Any?
    ) = logger.error(throwable, type, *arguments, message = message)

    /**
     * This method is similar to [Logger.info] method except that the message evaluated lazy.
     */
    @JvmOverloads
    fun info(
        throwable: Throwable? = null,
        type: LogType? = LogType.INFO,
        vararg arguments: Any?,
        message: () -> Any?
    ) = logger.info(throwable, type, *arguments, message = message)

    /**
     * This method is similar to [Logger.trace] method except that the message evaluated lazy.
     */
    @JvmOverloads
    fun trace(
        throwable: Throwable? = null,
        type: LogType? = LogType.TRACE,
        vararg arguments: Any?,
        message: () -> Any?
    ) = logger.trace(throwable, type, *arguments, message = message)

    /**
     * This method is similar to [Logger.warn] method except that the message evaluated lazy.
     */
    @JvmOverloads
    fun warn(
        throwable: Throwable? = null,
        type: LogType? = LogType.WARN,
        vararg arguments: Any?,
        message: () -> Any?
    ) = logger.warn(throwable, type, *arguments, message = message)

    /**
     * This method is similar to [Logger.error] method except that the message from the throwable
     */
    @JvmOverloads
    fun error(
        throwable: Throwable,
        type: LogType? = LogType.ERROR,
        vararg arguments: Any?
    ) = logger.error(throwable, type, *arguments)
}
