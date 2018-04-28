package io.github.kotlinmp.kotlog

expect object LoggerFactory {
    fun getLogger(name: String): Logger
}
