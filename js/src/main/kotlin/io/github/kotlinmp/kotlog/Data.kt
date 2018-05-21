package io.github.kotlinmp.kotlog

internal actual object PlatformDependedFeatures {
    actual fun getCurrentScope(): Scope? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun currentDateTime(): Pair<Date, Time> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun getErrorName(throwable: Throwable): String = "Error"
}
