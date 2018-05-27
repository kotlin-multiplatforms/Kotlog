package io.github.kotlinmp.kotlog

import org.slf4j.helpers.MarkerIgnoringBase

class KotlogLoggerAdapter(val logger: Logger) : MarkerIgnoringBase() {
    override fun warn(msg: String?) {
        logger.warn(msg ?: "")
    }

    override fun warn(format: String?, arg: Any?) {
        logger.warn(format ?: "", arguments = *arrayOf(arg))
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        logger.warn(format ?: "", arguments = *arguments)
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        logger.warn(format ?: "", arguments = *arrayOf(arg1, arg2))
    }

    override fun warn(msg: String?, t: Throwable?) {
        logger.warn(msg ?: "", t)
    }

    override fun getName(): String = logger.name

    override fun info(msg: String?) {
        logger.info(msg ?: "")
    }

    override fun info(format: String?, arg: Any?) {
        logger.info(format ?: "", arguments = *arrayOf(arg))
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        logger.info(format ?: "", arguments = *arrayOf(arg1, arg2))
    }

    override fun info(format: String?, vararg arguments: Any?) {
        logger.info(format ?: "", arguments = *arguments)
    }

    override fun info(msg: String?, t: Throwable?) {
        logger.info(msg ?: "", t)
    }

    override fun isErrorEnabled(): Boolean = logger.isErrorEnabled

    override fun error(msg: String?) {
        logger.error(msg ?: "")
    }

    override fun error(format: String?, arg: Any?) {
        logger.error(format ?: "", arguments = *arrayOf(arg))
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        logger.error(format ?: "", arguments = *arrayOf(arg1, arg2))
    }

    override fun error(format: String?, vararg arguments: Any?) {
        logger.error(format ?: "", arguments = *arguments)
    }

    override fun error(msg: String?, t: Throwable?) {
        logger.error(msg ?: "", t)
    }

    override fun isDebugEnabled(): Boolean = logger.isDebugEnabled

    override fun debug(msg: String?) {
        logger.debug(msg ?: "")
    }

    override fun debug(format: String?, arg: Any?) {
        logger.debug(format ?: "", arguments = *arrayOf(arg))
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        logger.debug(format ?: "", arguments = *arrayOf(arg1, arg2))
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        logger.debug(format ?: "", arguments = *arguments)
    }

    override fun debug(msg: String?, t: Throwable?) {
        logger.debug(msg ?: "", t)
    }

    override fun isInfoEnabled(): Boolean = logger.isInfoEnabled

    override fun trace(msg: String?) {
        logger.trace(msg ?: "")
    }

    override fun trace(format: String?, arg: Any?) {
        logger.trace(format ?: "", arguments = *arrayOf(arg))
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        logger.trace(format ?: "", arguments = *arrayOf(arg1, arg2))
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        logger.trace(format ?: "", arguments = *arguments)
    }

    override fun trace(msg: String?, t: Throwable?) {
        logger.trace(msg ?: "", t)
    }

    override fun isWarnEnabled(): Boolean = logger.isWarningEnabled


    override fun isTraceEnabled(): Boolean = logger.isTraceEnabled
}
