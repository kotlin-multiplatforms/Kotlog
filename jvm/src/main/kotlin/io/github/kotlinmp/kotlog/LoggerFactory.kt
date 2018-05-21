package io.github.kotlinmp.kotlog

import kotlin.reflect.KClass

actual object LoggerFactory {
    actual fun getLogger(name: String): Logger = Logger(name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after clazz
     * @return logger
     */
    fun getLogger(javaClass: Class<*>): Logger = Logger(javaClass.name)

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param javaClass the returned logger will be named after clazz
     * @return logger
     */
    fun getLogger(kClass: KClass<*>): Logger = Logger(kClass.java.name)

    inline fun <reified T> getLogger(): Logger = getLogger(T::class)
}
