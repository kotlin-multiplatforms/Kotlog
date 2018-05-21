package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field
import io.github.kotlinmp.kotlog.styling.BackgroundColor
import io.github.kotlinmp.kotlog.styling.Color
import io.github.kotlinmp.kotlog.styling.ForegroundColor

/**
 * This class defines the type of logs.
 *
 * @property label the label of type
 * @property foreground the foreground color of type
 * @property background the background color of type
 * @property badge the badge of type
 */
data class LogType(
    val label: String,
    val foreground: ForegroundColor,
    val background: BackgroundColor,
    val badge: String
) {
    companion object {
        /**
         * Standard type that meaning of information
         */
        @Field
        val INFO = LogType("info", Color.BLUE.foreground, Color.UNSET.background, "i")

        /**
         * Standard type that meaning of warning
         */
        @Field
        val WARN = LogType("warning", Color.YELLOW.foreground, Color.UNSET.background, "⚠")

        /**
         * Standard type that meaning of error
         */
        @Field
        val ERROR = LogType("error", Color.RED.foreground, Color.UNSET.background, "✖")

        /**
         * Standard type that meaning of debug
         */
        @Field
        val DEBUG = LogType("debug", Color.BLUE.foreground, Color.UNSET.background, "●")

        /**
         * Standard type that meaning of trace
         */
        @Field
        val TRACE = LogType("trace", Color.PURPLE.foreground, Color.UNSET.background, "…")
    }
}
