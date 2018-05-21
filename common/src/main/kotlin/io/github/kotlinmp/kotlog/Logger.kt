package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field

/**
 * This class uses to log some messages.
 */
expect class Logger {
    companion object {
        /**
         * Case insensitive String constant used to retrieve the name of the root logger.
         */
        @Field
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
