package io.github.kotlinmp.kotlog

import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime

internal actual object PlatformDependedFeatures {
    actual fun currentDateTime(): Pair<Date, Time> {
        val now = LocalDateTime.now()

        return Pair(Date(now.year, now.monthValue, now.dayOfMonth), Time(now.hour, now.minute, now.second))
    }

    actual fun getErrorName(throwable: Throwable): String = throwable::class.java.simpleName ?: "Error"

    actual fun makeStacktrace(throwable: Throwable): List<String> {
        val stringWriter = StringWriter()
        throwable.printStackTrace(PrintWriter(stringWriter))
        return stringWriter.toString().split('\n').drop(1).map { it.trim() }.filter { it.isNotEmpty() }
    }

    actual fun format(string: String, vararg arguments: Any?): String = string.format(*arguments)
}
