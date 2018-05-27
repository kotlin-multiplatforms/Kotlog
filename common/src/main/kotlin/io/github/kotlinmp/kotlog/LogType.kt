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
         * Standard type that meaning of 'no badge and label'
         */
        @Field
        val LOG = LogType("", Color.UNSET.foreground, Color.UNSET.background, "")

        /**
         * Standard type that meaning of awaiting
         */
        @Field
        val AWAIT = LogType("awaiting", Color.BLUE.foreground, Color.UNSET.background, "…")

        /**
         * Standard type that meaning of complete
         */
        @Field
        val COMPLETE = LogType("complete", Color.CYAN.foreground, Color.UNSET.background, "☒")

        /**
         * Standard type that meaning of debug
         */
        @Field
        val DEBUG = LogType("debug", Color.BLUE.foreground, Color.UNSET.background, "●")

        /**
         * Standard type that meaning of error
         */
        @Field
        val ERROR = LogType("error", Color.RED.foreground, Color.UNSET.background, "✖")

        /**
         * Standard type that meaning of information
         */
        @Field
        val INFO = LogType("info", Color.BLUE.foreground, Color.UNSET.background, "i")

        /**
         * Standard type that meaning of pause
         */
        @Field
        val PAUSE = LogType("pause", Color.YELLOW.foreground, Color.UNSET.background, "◼")

        /**
         * Standard type that meaning of pending
         */
        @Field
        val PENDING = LogType("pending", Color.MAGENTA.foreground, Color.UNSET.background, "☐")

        /**
         * Standard type that meaning of start
         */
        @Field
        val START = LogType("start", Color.GREEN.foreground, Color.UNSET.background, "▶")

        /**
         * Standard type that meaning of success
         */
        @Field
        val SUCCESS = LogType("success", Color.GREEN.foreground, Color.UNSET.background, "✔")

        /**
         * Standard type that meaning of trace
         */
        @Field
        val TRACE = LogType("trace", Color.PURPLE.foreground, Color.UNSET.background, "…")

        /**
         * Standard type that meaning of warning
         */
        @Field
        val WARN = LogType("warning", Color.YELLOW.foreground, Color.UNSET.background, "⚠")

        /**
         * Standard type that meaning of watch
         */
        @Field
        val WATCH = LogType("watching", Color.YELLOW.foreground, Color.UNSET.background, "…")
    }
}
