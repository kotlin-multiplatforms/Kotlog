package io.github.kotlinmp.kotlog.styling

import io.github.kotlinmp.kotlog.compat.Field
import io.github.kotlinmp.kotlog.compat.Name

/**
 * ANSI terminal style.
 */
sealed class Style {
    /**
     * The open of style
     */
    abstract val open: String
    /**
     * The close of style
     */
    abstract val close: String
}

/**
 * This class contains style that modifies the texts.
 */
class Modifier private constructor(openId: Int, closeId: Int) : Style() {
    companion object {
        /**
         * Resets all styles.
         */
        @Field
        val RESET = Modifier(0, 0)

        /**
         * Makes text bolder.
         */
        @Field
        val BOLD = Modifier(1, 22)

        /**
         * Make text lighter. (I don't know how's it works)
         */
        @Field
        val DIM = Modifier(2, 22)

        /**
         * Makes text italic.
         */
        @Field
        val ITALIC = Modifier(3, 23)

        /**
         * Adds underline to texts.
         */
        @Field
        val UNDERLINE = Modifier(4, 24)

        /**
         * Swaps foreground and background colors.
         */
        @Field
        val INVERSE = Modifier(7, 27)

        /**
         * Hides text, but note that not widely supported.
         */
        @Field
        val HIDDEN = Modifier(8, 28)

        /**
         * Adds strikethrough, but note that not widely supported.
         */
        @Field
        val STRIKETHROUGH = Modifier(9, 29)
    }

    override val open: String = if (ColorSupports.supportColors) "$ANSI_PREFIX${openId}m" else ""
    override val close: String = if (ColorSupports.supportColors) "$ANSI_PREFIX${closeId}m" else ""
}

private const val ANSI_PREFIX = "\u001B["

/**
 * This style changes the foreground color if coloring enabled.
 *
 * @property color The color
 */
class ForegroundColor(val color: Color) : Style() {

    override val open: String = if (color.isValid) {
        when {
            ColorSupports.supportHexRgbColors -> "${ANSI_PREFIX}38;2;${color.red};${color.green};${color.blue}m"
            ColorSupports.supportAnsi256Colors -> "${ANSI_PREFIX}38;5;${Converter.rgbToAnsi256(
                color.red,
                color.green,
                color.blue
            )}m"
            ColorSupports.supportAnsi16Colors -> "$ANSI_PREFIX${Converter.rgbToAnsi16(
                color.red,
                color.green,
                color.blue
            )}m"
            else -> ""
        }

    } else ""

    override val close: String = if (color.isValid && ColorSupports.supportColors) "\u001B[39m" else ""
}

/**
 * This style changes the background color if coloring enabled.
 *
 * @property color The color
 */
class BackgroundColor(val color: Color) : Style() {

    override val open: String = if (color.isValid) {
        when {
            ColorSupports.supportHexRgbColors -> "${ANSI_PREFIX}38;2;$${color.red};$${color.green};${color.blue}m"
            ColorSupports.supportAnsi256Colors -> "${ANSI_PREFIX}38;5;${Converter.rgbToAnsi256(
                color.red,
                color.green,
                color.blue
            ) + 10}m"
            ColorSupports.supportAnsi16Colors -> "$ANSI_PREFIX${Converter.rgbToAnsi16(
                color.red,
                color.green,
                color.blue
            ) + 10}m"
            else -> ""
        }

    } else ""

    override val close: String = if (color.isValid && ColorSupports.supportColors) "\u001B[49m" else ""
}

/**
 * This class contains sRGB colors.
 *
 * @property red The red component.
 * @property green The green component.
 * @property blue The blue component.
 */
class Color(val red: Int, val green: Int, val blue: Int) {
    /**
     * Whether all components are in the correct sRGB range
     */
    val isValid by lazy {
        red in 0..255 && green in 0..255 && blue in 0..255
    }

    companion object {

        /**
         * Make color from the hex code
         */
        @Name("ofHex")
        fun invoke(hex: String): Color {
            var data = hex
            if (hex[0] == '#') {
                data = hex.substring(1)
            }
            if (data.length != 6) {
                throw Exception("color data must be 6 hex digits")
            }
            try {
                val converted = data.toInt(16)
                return Color(converted shr 16 and 255, converted shr 8 and 255, converted shr 0 and 255)
            } catch (exception: NumberFormatException) {
                throw exception
            }
        }

        /**
         * Meaning no color
         */
        @Field
        val UNSET = Color(-1, -1, -1)

        /**
         * The color aqua
         */
        @Field
        val AQUA = Color(0, 255, 255)

        /**
         * The color black
         */
        @Field
        val BLACK = Color(0, 0, 0)

        /**
         * The color blue
         */
        @Field
        val BLUE = Color(0, 0, 255)

        /**
         * The color brown
         */
        @Field
        val BROWN = Color(165, 42, 42)

        /**
         * The color cyan
         */
        @Field
        val CYAN = Color(0, 255, 255)

        /**
         * The color gold
         */
        @Field
        val GOLD = Color(255, 215, 0)

        /**
         * The color gray
         */
        @Field
        val GRAY = Color(128, 128, 128)

        /**
         * The alias of [GRAY] for human
         */
        @Field
        val GREY = GRAY

        /**
         * The color purple
         */
        @Field
        val PURPLE = Color(128, 0, 128)

        /**
         * The color red
         */
        @Field
        val RED = Color(255, 0, 0)

        /**
         * The color white
         */
        @Field
        val WHITE = Color(255, 255, 255)

        /**
         * The color yellow
         */
        @Field
        val YELLOW = Color(255, 255, 0)


        /**
         * The color dark gray
         */
        @Field
        val DARK_GRAY = Color(169, 169, 169)

        /**
         * The alias of [DARK_GRAY] for human
         */
        @Field
        val DARK_GREY = DARK_GRAY
    }

    /**
     * Converts color to [ForegroundColor].
     */
    @get:Name("toForegroundColor")
    val foreground: ForegroundColor by lazy { ForegroundColor(this) }

    /**
     * Converts color to [BackgroundColor].
     */
    @get:Name("toBackgroundColor")
    val background: BackgroundColor by lazy { BackgroundColor(this) }
}
