package io.github.kotlinmp.kotlog

internal actual object PlatformDependedFeatures {
    actual fun currentDateTime(): Pair<Date, Time> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getErrorName(throwable: Throwable): String = "Error"
    actual fun makeStacktrace(throwable: Throwable): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun format(string: String, vararg arguments: Any?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
