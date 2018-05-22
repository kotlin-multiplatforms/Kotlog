package io.github.kotlinmp.kotlog

/**
 *  This object manufacture Logger instances by name.
 */
object CommonLoggerFactory {
    private val loggers = mutableMapOf<String, Logger>()

    /**
     * Return a logger named according to the name parameter
     *
     * @param name the name of the logger
     * @return logger
     */
    fun getLogger(name: String): Logger = loggers.getOrPut(name) { Logger(name) }
}
