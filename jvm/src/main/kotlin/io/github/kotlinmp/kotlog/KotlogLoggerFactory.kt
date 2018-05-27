package io.github.kotlinmp.kotlog

import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class KotlogLoggerFactory : ILoggerFactory {
    private val slf4jLoggers = mutableMapOf<String, KotlogLoggerAdapter>()

    override fun getLogger(name: String): Logger =
        slf4jLoggers.getOrPut(name) {
            KotlogLoggerAdapter(CommonLoggerFactory.getLogger(name))
        }
}
