package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.styling.Color
import io.github.kotlinmp.kotlog.styling.Modifier
import io.github.kotlinmp.kotlog.styling.removeAnsi

object LoggerConfiguration {
    var allowedTypes: List<LogType> = listOf()
        set(value) {
            field = value
            labelMax = allowedTypes.map { it.label.length }.max() ?: 0
            badgeMax = allowedTypes.map { it.badge.length }.max() ?: 0
        }
    private var labelMax: Int = 0
    private var badgeMax: Int = 0

    var logScopeName: Boolean = true
    var logDate: Boolean = false
    var logTime: Boolean = false

    var dateFormat: String = "[yyyy-MM-dd]"
    var timeFormat: String = "[hh:mm:ss]"

    var overridedScope: Scope? = null

    init {
        allowedTypes = listOf(
            LogType.INFO,
            LogType.WARN,
            LogType.ERROR,
            LogType.DEBUG,
            LogType.TRACE
        )
    }

    internal fun makePrefix(): String {
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
        } + if (logScopeName) {
            (PlatformDependedFeatures.getCurrentScope()?.name ?: overridedScope?.name ?: "Kotlog") + " "
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
                logType.background.close + logType.foreground.close +
                " " * (badgeMax - logType.badge.length) + " " +
                Modifier.UNDERLINE.open + logType.foreground.open + logType.background.open +
                logType.label +
                Modifier.UNDERLINE.close + logType.foreground.close + logType.background.close +
                " " * (labelMax - logType.label.length) + "  "

    internal fun makeStackTrace(prefix: String, message: String): String =
        Color.DARK_GRAY.foreground.open + " " * (removeAnsi(prefix).length + badgeMax + 1) + message + Color.DARK_GRAY.foreground.close
}
