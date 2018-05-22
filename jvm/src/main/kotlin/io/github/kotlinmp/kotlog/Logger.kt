package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field
import java.io.PrintWriter
import java.io.StringWriter


actual class Logger internal constructor(actual val name: String) {
    actual companion object {
        @Field
        actual val ROOT_LOGGER_NAME: String = "ROOT"
    }

    actual fun log(
        level: LogLevel,
        message: String,
        throwable: Throwable?,
        type: LogType?,
        vararg arguments: Any?
    ) {
        val prefix = LoggerConfiguration.makePrefix(this)
        val typeString = (type?.let(LoggerConfiguration::beautify) ?: "")
        val formattedMessages = (if (arguments.isEmpty()) message else message.format(*arguments)).split('\n')
        println(prefix + typeString + formattedMessages[0])
        formattedMessages.drop(1).forEach {
            println(LoggerConfiguration.makeIndent(prefix) + it)
        }
        if (throwable != null) {
            val stringWriter = StringWriter()
            throwable.printStackTrace(PrintWriter(stringWriter))
            stringWriter.toString().split('\n').drop(1).map { it.trim() }.filter { it.isNotEmpty() }.forEach {
                println(LoggerConfiguration.makeStackTrace(prefix, it))
            }
        }
    }
}
