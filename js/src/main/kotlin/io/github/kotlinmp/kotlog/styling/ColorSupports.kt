package io.github.kotlinmp.kotlog.styling

actual object ColorSupports {

    private val supportsColor: dynamic = js("require('supports-color')")

    actual val supportColors: Boolean by lazy {
        supportsColor.stdout != false
    }
    actual val supportAnsi16Colors: Boolean by lazy {
        supportsColor.stdout?.hasBasic == true
    }
    actual val supportAnsi256Colors: Boolean by lazy {
        supportsColor.stdout?.has256 == true
    }
    actual val supportHexRgbColors: Boolean by lazy {
        supportsColor.stdout?.has16m == true
    }
}
