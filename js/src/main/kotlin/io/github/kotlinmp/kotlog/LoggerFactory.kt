package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.CompatLogger

object LoggerFactory {
    fun getLogger(name: String): Logger = CommonLoggerFactory.getLogger(name)

    fun getCompatLogger(name: String): CompatLogger = CommonLoggerFactory.getCompatLogger(name)
}
