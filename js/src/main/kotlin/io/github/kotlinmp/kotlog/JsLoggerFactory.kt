package io.github.kotlinmp.kotlog

object JsLoggerFactory {
     fun getLogger(name: String): Logger = CommonLoggerFactory.getLogger(name)
}
