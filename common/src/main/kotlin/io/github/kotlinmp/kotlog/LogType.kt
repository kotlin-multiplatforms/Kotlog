package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field
import io.github.kotlinmp.kotlog.styling.BackgroundColor
import io.github.kotlinmp.kotlog.styling.Color
import io.github.kotlinmp.kotlog.styling.ForegroundColor

/**
 * This class defines the type of logs
 */
data class LogType(
    val label: String,
    val foreground: ForegroundColor,
    val background: BackgroundColor,
    val badge: String
) {
    companion object {
        @Field
        val INFO = LogType("info", Color.BLUE.foreground, Color.UNSET.background, "i")
        @Field
        val WARN = LogType("warning", Color.YELLOW.foreground, Color.UNSET.background, "⚠")
        @Field
        val ERROR = LogType("error", Color.RED.foreground, Color.UNSET.background, "✖")
        @Field
        val DEBUG = LogType("debug", Color.BLUE.foreground, Color.UNSET.background, "●")
        @Field
        val TRACE = LogType("trace", Color.PURPLE.foreground, Color.UNSET.background, "…")
    }
}
