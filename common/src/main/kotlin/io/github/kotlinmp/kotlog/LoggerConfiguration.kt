package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Static
import io.github.kotlinmp.kotlog.styling.Color
import io.github.kotlinmp.kotlog.styling.Modifier
import io.github.kotlinmp.kotlog.styling.removeAnsi
import kotlin.math.max

/**
 * This object contains the configuration of whole loggers.
 */
object LoggerConfiguration {
    /**
     * Contains allowed types for logger.
     */
    @Static
    var allowedTypes: Set<LogType> = setOf()
        set(value) {
            field = value
            labelMax = allowedTypes.map { it.label.length }.max() ?: 0
            badgeMax = allowedTypes.map { it.badge.length }.max() ?: 0
        }

    private var labelMax: Int = 0
    private var badgeMax: Int = 0
    private var loggerMax: Int = 0

    /**
     * Set or get global log level.
     */
    @Static
    var globalLogLevel: LogLevel = LogLevel.ERROR

    /**
     * Whether all loggers log the name of logger.
     */
    @Static
    var logLoggetName: Boolean = true

    /**
     * Whether all loggers log the date.
     */
    @Static
    var logDate: Boolean = false

    /**
     * Whether all loggers log the time.
     */
    @Static
    var logTime: Boolean = false


    /**
     * The format of date that similar to SimpleDateFormat
     */
    @Static
    var dateFormat: String = "[yyyy-MM-dd]"

    /**
     * The format of time that similar to SimpleDateFormat
     */
    @Static
    var timeFormat: String = "[hh:mm:ss]"

    init {
        allowedTypes = setOf(
            LogType.INFO,
            LogType.WARN,
            LogType.ERROR,
            LogType.DEBUG,
            LogType.TRACE
        )
    }

    fun extendWebTypes() {
        allowedTypes += setOf(
            LogType.INFO, // 1xx
            LogType.SUCCESS, // 2xx
            LogType.REDIRECTION, // 3xx
            LogType.ERROR // 4xx, 5xx
        )
    }

    internal fun makePrefix(logger: Logger): String {
        val now = PlatformDependedFeatures.currentDateTime()
        return (if (logDate) {
            val date = now.first
            dateFormat.replace("yyyy", date.year.toString()).replace("yyy", (date.year % 1000).toString())
                .replace("yy", (date.year % 100).toString()).replace("y", (date.year % 10).toString())
                .replace("MM", date.month.toString().padStart(2, '0')).replace("M", date.month.toString())
                .replace("dd", date.day.toString().padStart(2, '0')).replace("d", date.day.toString()) + " "
        } else {
            ""
        } + if (logTime) {
            val time = now.second
            timeFormat
                .replace("hh", time.hour.toString().padStart(2, '0')).replace("h", time.hour.toString())
                .replace("mm", time.minute.toString().padStart(2, '0')).replace("m", time.minute.toString())
                .replace("ss", time.second.toString().padStart(2, '0')).replace("s", time.second.toString()) + " "
        } else {
            ""
        } + if (logLoggetName) {
            val loggerName = "${logger.name} "
            loggerMax = max(loggerMax, loggerName.length)
            loggerName.padEnd(loggerMax, ' ')
        } else {
            ""
        }).let {
            if (it.isNotEmpty()) {
                Color.DARK_GRAY.foreground.open + "$it›" + Color.DARK_GRAY.foreground.close + "  "
            } else {
                it
            }
        }
    }

    internal fun beautify(logType: LogType): String =
        logType.foreground.open + logType.background.open +
                logType.badge +
                " " * (badgeMax - logType.badge.length) + " " +
                logType.background.close + logType.foreground.close +
                Modifier.UNDERLINE.open +
                logType.foreground.open + logType.background.open +
                logType.label +
                Modifier.UNDERLINE.close +
                " " +
                logType.foreground.close + logType.background.close +
                " " * (labelMax - logType.label.length) + " "

    internal fun makeIndent(prefix: String): String = " " * (removeAnsi(prefix).length + badgeMax - 1) +
            Color.DARK_GRAY.foreground.open + "│ " + Color.DARK_GRAY.foreground.close
}
