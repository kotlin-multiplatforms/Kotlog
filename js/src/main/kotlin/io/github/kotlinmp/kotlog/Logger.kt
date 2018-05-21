package io.github.kotlinmp.kotlog

actual class Logger {
    actual companion object {
        /**
         * Case insensitive String constant used to retrieve the name of the root logger.
         */
        actual val ROOT_LOGGER_NAME: String
            get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * The name of this logger instance.
     */
    actual val name: String
        get() = TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    /**
     * Log an message at the DEBUG level with an according to the specified format and arguments.
     * If the exception (throwable) is not null, log that with the message.
     *
     * @param type The type. it adds the label of
     * @param message The message. If arguments isn't empty, format the message with arguments.
     * @param throwable The exception (throwable) to log.
     * @param arguments The arguments. If it isn't empty, the message is formatted through this.
     */
    actual fun log(
        level: LogLevel,
        message: String,
        throwable: Throwable?,
        type: LogType?,
        vararg arguments: Any?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
