package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.CompatLogger
import io.github.kotlinmp.kotlog.compat.Static
import kotlin.reflect.KClass

actual object LoggerFactory {
    private val loggers = mutableMapOf<String, Logger>()
    private val javaLoggers = mutableMapOf<String, CompatLogger>()

    actual fun getLogger(name: String): Logger = loggers.getOrPut(name) { Logger(name) }

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after class
     * @return logger
     */
    @Static
    fun getLogger(javaClass: Class<*>): Logger = getLogger(javaClass.name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param kClass the returned logger will be named after class
     * @return logger
     */
    @Static
    fun getLogger(kClass: KClass<*>): Logger = getLogger(kClass.java.name)

    /**
     * Return a java-compatible logger named according to the name parameter.
     *
     * @param name The name of the logger.
     * @return logger
     */
    @Static
    fun getCompatLogger(name: String): CompatLogger = javaLoggers.getOrPut(name) { CompatLogger(getLogger(name)) }

    /**
     * Return a java-compatible logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after class
     * @return logger
     */
    @Static
    fun getCompatLogger(javaClass: Class<*>): CompatLogger = getCompatLogger(javaClass.name)

    /**
     * Return a logger named corresponding to the reified class.
     *
     * @return logger
     */
    inline fun <reified T> getLogger(): Logger = getLogger(T::class)
}
