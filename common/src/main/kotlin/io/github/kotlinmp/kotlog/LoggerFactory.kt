package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Static

/**
 * The [LoggerFactory] is a utility class producing Loggers for multi platform abstraction.
 *
 * Please note that all [LoggerFactory] are object.
 */
expect object LoggerFactory {
    /**
     * Return a logger named according to the name parameter.
     *
     * @param name The name of the logger.
     * @return logger
     */
    @Static
    fun getLogger(name: String): Logger
}
