package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Name

/**
 *  This object manufacture Logger instances by name.
 */
object CommonLoggerFactory {
    private val loggers = mutableMapOf<String, Logger>()

    /**
     * The root logger instance in this library.
     */
    @get:Name("getRootLogger")
    val ROOT_LOGGER by lazy {
        getLogger(Logger.ROOT_LOGGER_NAME)
    }

    /**
     * Return a logger named according to the name parameter
     *
     * @param name the name of the logger
     * @return logger
     */
    fun getLogger(name: String): Logger = loggers.getOrPut(name) { Logger(name) }
}
