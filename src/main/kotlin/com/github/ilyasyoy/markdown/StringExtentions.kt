package com.github.ilyasyoy.markdown


fun String.monospace() = monospace(this)
fun String.mono() = monospace(this)
fun String.code() = monospace(this)

fun String.bold(mode: EmphasisMode = EmphasisMode.DEFAULT): String = b(this, mode)
fun String.b(mode: EmphasisMode = EmphasisMode.DEFAULT): String = b(this, mode)

fun String.italic(mode: EmphasisMode = EmphasisMode.DEFAULT): String = i(this, mode)
fun String.i(mode: EmphasisMode = EmphasisMode.DEFAULT): String = i(this, mode)

fun String.link(to: String, reference: Boolean = false): String = link(this, to, reference)
fun String.image(to: String, reference: Boolean = false): String = image(this, to, reference)

fun String.escape(char: Char, ignoreCase: Boolean = false) =
    this.replace(char.toString(), "\\${char}", ignoreCase)

fun String.escape(vararg chars: Char, ignoreCase: Boolean = false) =
    chars.fold(this) { escaped, char -> escaped.escape(char, ignoreCase) }