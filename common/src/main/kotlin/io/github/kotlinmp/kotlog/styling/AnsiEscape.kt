package io.github.kotlinmp.kotlog.styling

/*
 * This regex came from https://github.com/chalk/ansi-regex
 */
private val REGEX =
    Regex(
        """[\u001B\u009B][\[\]()#;?]*(?:(?:(?:[a-zA-Z\d]*(?:;[a-zA-Z\d]*)*)?\u0007)|(?:(?:\d{1,4}(?:;\d{0,4})*)?[\dA-PRZcf-ntqry=><~]))"""
    )

internal fun removeAnsi(string: String): String = REGEX.replace(string, "")
