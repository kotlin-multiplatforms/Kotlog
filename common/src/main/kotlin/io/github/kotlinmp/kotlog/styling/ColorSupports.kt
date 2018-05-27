package io.github.kotlinmp.kotlog.styling

/**
 * This class contains whether the terminal supports colors.
 */
expect object ColorSupports {
    /**
     * Whether any color supported.
     */
    val supportColors: Boolean
    /**
     * Whether ANSI 16 color supported.
     */
    val supportAnsi16Colors: Boolean
    /**
     * Whether ANSI 256(8bit) color supported.
     */
    val supportAnsi256Colors: Boolean
    /**
     * Whether RGB(16 million) color supported.
     */
    val supportHexRgbColors: Boolean
}
