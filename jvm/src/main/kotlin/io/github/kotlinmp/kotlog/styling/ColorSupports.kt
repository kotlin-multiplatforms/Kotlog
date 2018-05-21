package io.github.kotlinmp.kotlog.styling

/**
 * These code came from https://github.com/chalk/supports-color
 */
actual object ColorSupports {
    actual val supportColors: Boolean
    actual val supportAnsi16Colors: Boolean
    actual val supportAnsi256Colors: Boolean
    actual val supportHexRgbColors: Boolean

    init {
        val TEAMCITY = System.getenv("TEAMCITY_VERSION")
        val TERM_PROGRAM = System.getenv("TERM_PROGRAM")
        val TERM = System.getenv("TERM")

        if (System.getProperty("java.class.path").contains("idea_rt.jar")) {
            // IntelliJ
            supportColors = true
            supportAnsi16Colors = true
            supportAnsi256Colors = false
            supportHexRgbColors = false
        } else if (System.console() == null) {
            supportColors = false
            supportAnsi16Colors = false
            supportAnsi256Colors = false
            supportHexRgbColors = false
        } else if ("win" in System.getProperty("os.name").toLowerCase()) {
            /**
             * Windows 10 build 10586 is the first Windows release that supports 256 colors.
             * Windows 10 build 14931 is the first release that supports 16m/TrueColor.
             */
            supportColors = true
            supportAnsi16Colors = true
            val osRelease = System.getProperty("os.version").split('.')
            if (
                try {
                    Integer.parseInt(osRelease[0]) >= 10 && Integer.parseInt(osRelease[2]) >= 10586
                } catch (error: NumberFormatException) {
                    false
                } catch (error: IndexOutOfBoundsException) {
                    false
                }
            ) {
                supportAnsi256Colors = true
                supportHexRgbColors = Integer.parseInt(osRelease[2]) >= 14931
            } else {
                supportAnsi256Colors = false
                supportHexRgbColors = false
            }
        } else if (System.getenv("CI") !== null) {
            if (
                listOf("TRAVIS", "CIRCLECI", "APPVEYOR", "GITLAB_CI").any { System.getenv(it) !== null } ||
                System.getenv("CI_NAME") === "codeship"
            ) {
                supportColors = true
                supportAnsi16Colors = true
            } else {
                supportColors = false
                supportAnsi16Colors = false
            }

            supportAnsi256Colors = false
            supportHexRgbColors = false
        } else if (TEAMCITY !== null) {
            if (Regex("^(9\\.(0*[1-9]\\d*)\\.|\\d{2,}\\.)").matches(TEAMCITY)) {
                supportColors = true
                supportAnsi16Colors = true
            } else {
                supportColors = false
                supportAnsi16Colors = false
            }
            supportAnsi256Colors = false
            supportHexRgbColors = false
        } else if (System.getenv("COLORTERM") === "truecolor") {
            supportColors = true
            supportAnsi16Colors = true
            supportAnsi256Colors = true
            supportHexRgbColors = true
        } else if (TERM_PROGRAM in listOf("iTerm.app", "Apple_Terminal")) {
            val version = Integer.parseInt((System.getenv("TERM_PROGRAM_VERSION") ?: "").split('.')[0])

            supportColors = true
            supportAnsi16Colors = true
            supportAnsi256Colors = true
            supportHexRgbColors = TERM_PROGRAM == "iTerm.app" && version >= 3
        } else if (Regex("-256(color)?$", RegexOption.IGNORE_CASE).matches(TERM)) {
            supportColors = true
            supportAnsi16Colors = true
            supportAnsi256Colors = true
            supportHexRgbColors = false
        } else if (Regex(
                "^screen|^xterm|^vt100|^rxvt|color|ansi|cygwin|linux",
                RegexOption.IGNORE_CASE
            ).matches(TERM) || System.getenv("COLORTERM") !== null
        ) {
            supportColors = true
            supportAnsi16Colors = true
            supportAnsi256Colors = false
            supportHexRgbColors = false
        } else {
            supportColors = false
            supportAnsi16Colors = false
            supportAnsi256Colors = false
            supportHexRgbColors = false
        }
    }
}
