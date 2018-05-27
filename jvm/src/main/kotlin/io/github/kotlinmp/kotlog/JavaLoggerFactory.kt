package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.CompatLogger
import kotlin.reflect.KClass

/**
 *  This object manufacture Logger instances by name.
 */
object JavaLoggerFactory {
    private val loggers = mutableMapOf<String, Logger>()

    /**
     * Return a logger named according to the name parameter
     *
     * @param name the name of the logger
     * @return logger
     */
    @JvmStatic
    fun getLogger(name: String): Logger = CommonLoggerFactory.getLogger(name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after class
     * @return logger
     */
    @JvmStatic
    fun getLogger(javaClass: Class<*>): Logger = getLogger(javaClass.name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param kClass the returned logger will be named after class
     * @return logger
     */
    @JvmStatic
    fun getLogger(kClass: KClass<*>): Logger = getLogger(kClass.java.name)

    /**
     * Return a java-compatible logger named according to the name parameter.
     *
     * @param name The name of the logger.
     * @return logger
     */
    @JvmStatic
    fun getCompatLogger(name: String): CompatLogger = CommonLoggerFactory.getCompatLogger(name)

    /**
     * Return a java-compatible logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after class
     * @return logger
     */
    @JvmStatic
    fun getCompatLogger(javaClass: Class<*>): CompatLogger =
        getCompatLogger(javaClass.name)

    /**
     * Return a logger named corresponding to the reified class.
     *
     * @return logger
     */
    inline fun <reified T> getLogger(): Logger = getLogger(T::class)
}
