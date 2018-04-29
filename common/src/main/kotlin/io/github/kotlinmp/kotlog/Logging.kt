package io.github.kotlinmp.kotlog

open class Logging(name: String) {
    val logger: Logger = LoggerFactory.getLogger(name)
}
