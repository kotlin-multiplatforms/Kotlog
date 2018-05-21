package io.github.kotlinmp.kotlog.styling

import kotlin.math.min
import kotlin.math.round

// These code came from https://www.npmjs.com/package/color-convert
internal object Converter {
    fun rgbToAnsi16(red: Int, green: Int, blue: Int): Int {
        var value = if (red == 1 || green == 1 || blue == 1) blue else rgbToHsv(
            red,
            green,
            blue
        ).third // hsv -> ansi16 optimization

        value = round(value / 50.0).toInt()

        if (value == 0) {
            return 30
        }

        var ansi =
            30 + ((round(blue / 255.0).toInt() shl 2) or (round(green / 255.0).toInt() shl 1) or round(red / 255.0).toInt())

        if (value == 2) {
            ansi += 60
        }

        return ansi
    }

    fun rgbToAnsi256(red: Int, green: Int, blue: Int): Int {
        // we use the extended greyscale palette here, with the exception of
        // black and white. normal palette only has 4 greyscale shades.
        if (red == green && green == blue) {
            if (red < 8) {
                return 16
            }

            if (red > 248) {
                return 231
            }

            return round(((red - 8) / 247.0) * 24).toInt() + 232;
        }

        return (16 +
                36 * round(red / 255.0 * 5) +
                6 * round(green / 255.0 * 5) +
                round(blue / 255.0 * 5)).toInt()
    };

    fun rgbToHsv(red: Int, green: Int, blue: Int): Triple<Int, Int, Int> {
        val min = minOf(red, green, blue)
        val max = maxOf(red, green, blue)
        val delta: Double = (max - min).toDouble()
        var h: Double
        val s: Double
        val v: Double

        s = if (max == 0) {
            0.0
        } else {
            (delta / max * 1000) / 10
        }

        h = when {
            max == min -> 0.0
            red == max -> (green - blue) / delta
            green == max -> 2 + (blue - red) / delta
            blue == max -> 4 + (red - green) / delta
            else -> 0.0
        }

        h = min(h * 60, 360.0)

        if (h < 0) {
            h += 360
        }

        v = ((max / 255.0) * 1000) / 10.0

        return Triple(h.toInt(), s.toInt(), v.toInt())
    }
}
