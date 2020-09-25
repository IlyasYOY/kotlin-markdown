package com.github.ilyasyoy.markdown

fun bold(text: String?, mode: EmphasisMode = EmphasisMode.DEFAULT): String =
    prefixNotEmptyStringIdempotent(text, mode.symbol, 2)

fun b(text: String?, mode: EmphasisMode = EmphasisMode.DEFAULT): String = bold(text, mode)

fun italic(text: String?, mode: EmphasisMode = EmphasisMode.DEFAULT): String =
    prefixNotEmptyStringIdempotent(text, mode.symbol, 1)

fun i(text: String?, mode: EmphasisMode = EmphasisMode.DEFAULT): String = italic(text, mode)

fun monospace(text: String?): String =
    prefixNotEmptyStringIdempotent(text, '`', 1)

fun mono(text: String?): String = monospace(text)
fun code(text: String?): String = monospace(text)


fun link(text: String, to: String, reference: Boolean = false): String {
    text.ifEmpty {
        return ""
    }

    val escapedText = text.escape('[', ']')

    return if (reference) {
        val escapedTo = to.escape('[', ']')
        "[$escapedText][$escapedTo]"
    } else {
        val escapedTo = to.escape('(', ')')
        "[$escapedText]($escapedTo)"
    }
}

fun image(text: String, to: String, reference: Boolean = false): String {
    text.ifEmpty {
        return ""
    }

    return "!" + link(text, to, reference)
}

enum class EmphasisMode(
    val symbol: Char
) {
    UNDERSCORE('_'),
    ASTERISK('*');

    companion object {
        val DEFAULT: EmphasisMode = UNDERSCORE
    }
}

private fun prefixNotEmptyStringIdempotent(
    text: String?,
    char: Char,
    lengthOfPrefix: Int
): String = text.orEmpty()
    .let {
        it.ifEmpty {
            return it
        }
        val suffix = char.toString().repeat(lengthOfPrefix)
        if (it.startsWith(suffix) && it.endsWith(suffix)) {
            it
        } else {
            suffix + it.escape(char) + suffix
        }
    }

