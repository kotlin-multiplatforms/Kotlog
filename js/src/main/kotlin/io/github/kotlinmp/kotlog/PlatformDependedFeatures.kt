package io.github.kotlinmp.kotlog

internal actual object PlatformDependedFeatures {

    actual fun currentDateTime(): Pair<Date, Time> {
        val date = kotlin.js.Date()
        return Pair(
            Date(date.getFullYear(), date.getMonth(), date.getDay()),
            Time(date.getHours(), date.getMinutes(), date.getSeconds())
        )
    }

    actual fun getErrorName(throwable: Throwable): String = "Error"
    actual fun makeStacktrace(throwable: Throwable): List<String> {
        return (throwable.asDynamic()?.stack as? String)?.split('\n')?.drop(1)?.map { it.trim() } ?: emptyList()
    }

    actual fun format(string: String, vararg arguments: Any?): String {
        return Util.format(string, *arguments)
    }
}

@JsModule("util")
@JsNonModule
external object Util {
    fun format(string: String, vararg arguments: Any?): String
}
