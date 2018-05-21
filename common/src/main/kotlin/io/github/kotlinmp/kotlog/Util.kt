package io.github.kotlinmp.kotlog

operator fun String.times(int: Int): String {
    var c = int
    val builder = StringBuilder()
    while (c-- > 0) {
        builder.append(this)
    }
    return builder.toString()
}

class Scope(val name: String)

data class Date(val year: Int, val month: Int, val day: Int)
data class Time(val hour: Int, val minute: Int, val second: Int)

internal expect object PlatformDependedFeatures {
    fun getCurrentScope(): Scope?

    fun currentDateTime(): Pair<Date, Time>

    fun getErrorName(throwable: Throwable): String
}
