package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.CompatLogger
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
    fun getLogger(javaClass: Class<*>): Logger = getLogger(javaClass.name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param kClass the returned logger will be named after class
     * @return logger
     */
    fun getLogger(kClass: KClass<*>): Logger = getLogger(kClass.java.name)

    fun getJavaLogger(name: String): CompatLogger = javaLoggers.getOrPut(name) { CompatLogger(getLogger(name)) }

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after class
     * @return logger
     */
    fun getJavaLogger(javaClass: Class<*>): CompatLogger = getJavaLogger(javaClass.name)

    inline fun <reified T> getLogger(): Logger = getLogger(T::class)
}
