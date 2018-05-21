package io.github.kotlinmp.kotlog.styling

expect object ColorSupports {
    val supportColors: Boolean
    val supportAnsi16Colors: Boolean
    val supportAnsi256Colors: Boolean
    val supportHexRgbColors: Boolean
}
