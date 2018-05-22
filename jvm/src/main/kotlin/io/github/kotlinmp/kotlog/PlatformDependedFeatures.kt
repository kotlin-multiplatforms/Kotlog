package io.github.kotlinmp.kotlog

import java.time.LocalDateTime

internal actual object PlatformDependedFeatures {
    actual fun currentDateTime(): Pair<Date, Time> {
        val now = LocalDateTime.now()

        return Pair(Date(now.year, now.monthValue, now.dayOfMonth), Time(now.hour, now.minute, now.second))
    }

    actual fun getErrorName(throwable: Throwable): String = throwable::class.java.simpleName ?: "Error"
}
