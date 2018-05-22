package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field
import io.github.kotlinmp.kotlog.styling.Color

/**
 * This class uses to log some messages.
 *
 * @property name The name of this logger instance.
 */
class Logger internal constructor(val name: String) {
    companion object {
        /**
         * Case insensitive String constant used to retrieve the name of the root logger.
         */
        @Field
        val ROOT_LOGGER_NAME: String = "ROOT"
    }

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
    ) {
        val prefix = LoggerConfiguration.makePrefix(this)
        val typeString = (type?.let(LoggerConfiguration::beautify) ?: "")
        val formattedMessages =
            (if (arguments.isEmpty()) message
            else PlatformDependedFeatures.format(message, *arguments)).split('\n')
        println(prefix + typeString + formattedMessages[0])
        formattedMessages.drop(1).forEach {
            println(LoggerConfiguration.makeIndent(prefix) + it)
        }
        if (throwable != null) {
            PlatformDependedFeatures.makeStacktrace(throwable).forEach {
                println(
                    Color.DARK_GRAY.foreground.open +
                            LoggerConfiguration.makeIndent(prefix) + it +
                            Color.DARK_GRAY.foreground.close
                )
            }
        }
    }
}
