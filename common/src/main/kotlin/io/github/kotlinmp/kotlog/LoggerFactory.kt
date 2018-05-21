package io.github.kotlinmp.kotlog

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
    fun getLogger(name: String): Logger
}
