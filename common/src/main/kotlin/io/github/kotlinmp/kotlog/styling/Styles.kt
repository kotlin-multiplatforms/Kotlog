package io.github.kotlinmp.kotlog.styling

sealed class Style {
    abstract val open: String
    abstract val close: String
}

class Modifier private constructor(openId: Int, closeId: Int) : Style() {
    companion object {
        val RESET = Modifier(0, 0)
        val BOLD = Modifier(1, 22)
        val DIM = Modifier(2, 22)
        val ITALIC = Modifier(3, 23)
        val UNDERLINE = Modifier(4, 24)
        val INVERSE = Modifier(7, 27)
        val HIDDEN = Modifier(8, 28)
        val STRIKETHROUGH = Modifier(9, 29)
    }

    override val open: String = if (ColorSupports.supportColors) "$ANSI_PREFIX${openId}m" else ""
    override val close: String = if (ColorSupports.supportColors) "$ANSI_PREFIX${closeId}m" else ""
}

private const val ANSI_PREFIX = "\u001B["

class ForegroundColor(color: Color) : Style() {
    val red: Int = color.red
    val green: Int = color.green
    val blue: Int = color.blue

    override val open: String = if (color.isValid) {
        when {
            ColorSupports.supportHexRgbColors -> "${ANSI_PREFIX}38;2;$red;$green;${blue}m"
            ColorSupports.supportAnsi256Colors -> "${ANSI_PREFIX}38;5;${Converter.rgbToAnsi256(red, green, blue)}m"
            ColorSupports.supportAnsi16Colors -> "$ANSI_PREFIX${Converter.rgbToAnsi16(red, green, blue)}m"
            else -> ""
        }

    } else ""

    override val close: String = if (color.isValid && ColorSupports.supportColors) "\u001B[39m" else ""
}

class BackgroundColor(color: Color) : Style() {
    val red: Int = color.red
    val green: Int = color.green
    val blue: Int = color.blue

    override val open: String = if (color.isValid) {
        when {
            ColorSupports.supportHexRgbColors -> "${ANSI_PREFIX}38;2;$red;$green;${blue}m"
            ColorSupports.supportAnsi256Colors -> "${ANSI_PREFIX}38;5;${Converter.rgbToAnsi256(red, green, blue) + 10}m"
            ColorSupports.supportAnsi16Colors -> "$ANSI_PREFIX${Converter.rgbToAnsi16(red, green, blue) + 10}m"
            else -> ""
        }

    } else ""

    override val close: String = if (color.isValid && ColorSupports.supportColors) "\u001B[49m" else ""
}

sealed class Color {
    abstract val red: Int
    abstract val green: Int
    abstract val blue: Int

    val isValid by lazy {
        red in 0..255 && green in 0..255 && blue in 0..255
    }

    companion object {
        val UNSET = UnsettedColor

        val AQUA = RgbColor(0, 255, 255)
        val BLACK = RgbColor(0, 0, 0)
        val BLUE = RgbColor(0, 0, 255)
        val BROWN = RgbColor(165, 42, 42)
        val CYAN = RgbColor(0, 255, 255)
        val GOLD = RgbColor(255, 215, 0)
        val GRAY = RgbColor(128, 128, 128)
        // alias for human
        val GREY = GRAY
        val PURPLE = RgbColor(128, 0, 128)
        val RED = RgbColor(255, 0, 0)
        val WHITE = RgbColor(255, 255, 255)
        val YELLOW = RgbColor(255, 255, 0)

        val DARK_GRAY = RgbColor(169, 169, 169)
        // alias for human
        val DARK_GREY = DARK_GRAY

        object UnsettedColor : Color() {
            override val red: Int = -1
            override val green: Int = -1
            override val blue: Int = -1
        }
    }

    val foreground: ForegroundColor by lazy { ForegroundColor(this) }
    val background: BackgroundColor by lazy { BackgroundColor(this) }
}

class RgbColor(override val red: Int, override val green: Int, override val blue: Int) : Color()

class HexColor(color: String) : Color() {
    override val red: Int
    override val green: Int
    override val blue: Int

    init {
        var data = color
        if (color[0] == '#') {
            data = color.substring(1)
        }
        if (data.length != 6) {
            throw Exception("color data must be 6 hex digits")
        }
        try {
            val converted = data.toInt(16)
            this.red = converted shr 16 and 255
            this.green = converted shr 8 and 255
            this.blue = converted shr 0 and 255
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }
}
