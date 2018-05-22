package io.github.kotlinmp.kotlog

internal operator fun String.times(int: Int): String {
    var c = int
    val builder = StringBuilder()
    while (c-- > 0) {
        builder.append(this)
    }
    return builder.toString()
}

/**
 * This class contains date data.
 *
 * @property year The year
 * @property month The month
 * @property day The day
 */
data class Date(val year: Int, val month: Int, val day: Int)

/**
 * This class contains time data.
 *
 * @property hour The hour
 * @property minute The minute
 * @property second The second
 */
data class Time(val hour: Int, val minute: Int, val second: Int)

internal expect object PlatformDependedFeatures {
    fun currentDateTime(): Pair<Date, Time>

    fun getErrorName(throwable: Throwable): String
}
