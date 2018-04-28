package io.github.kotlinmp.kotlog

expect class LoggerFactory {
    fun getLogger(name: String): Logger
}
