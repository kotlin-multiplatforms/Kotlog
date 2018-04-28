package io.github.kotlinmp.kotlog

import org.slf4j.LoggerFactory

actual object LoggerFactory {
    actual fun getLogger(name: String): Logger = Logger(LoggerFactory.getLogger(name))
}
