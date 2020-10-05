package com.github.ilyasyoy.markdown

import net.steppschuh.markdowngenerator.MarkdownBuilder
import net.steppschuh.markdowngenerator.MarkdownSerializable
import net.steppschuh.markdowngenerator.list.TaskListItem
import net.steppschuh.markdowngenerator.text.TextBuilder

class MarkdownDsl(
        val contentBuilder: MarkdownBuilder<*, *> = TextBuilder()
) {
    fun render() = contentBuilder.toString()

    fun String.bold() {
        this@MarkdownDsl.bold(this)
    }

    fun String.italic() {
        this@MarkdownDsl.italic(this)
    }

    fun String.strikeThrough() {
        this@MarkdownDsl.strikeThrough(this)
    }

    fun String.code() {
        this@MarkdownDsl.code(this)
    }

    fun String.linkTo(url: String) {
        this@MarkdownDsl.link(this, url)
    }

    fun String.image(url: String) {
        this@MarkdownDsl.image(this, url)
    }
}

fun markdown(applier: MarkdownDsl.() -> Unit): MarkdownDsl {
    val markdownDsl = MarkdownDsl()
    markdownDsl.applier()
    return markdownDsl
}

fun MarkdownDsl.quote(applier: MarkdownDsl.() -> Unit): MarkdownDsl {
    val quoteBuilder = contentBuilder.beginQuote()
    val markdownDsl = MarkdownDsl(quoteBuilder)
    markdownDsl.applier()
    contentBuilder.append(quoteBuilder)
    return markdownDsl
}

fun MarkdownDsl.list(applier: MarkdownDsl.() -> Unit): MarkdownDsl {
    val listBuilder = contentBuilder.beginList()
    val markdownDsl = MarkdownDsl(listBuilder)
    markdownDsl.applier()
    contentBuilder.append(listBuilder)
    return markdownDsl
}

fun MarkdownDsl.code(language: String? = null, applier: MarkdownDsl.() -> Unit): MarkdownDsl {
    val codeBlockBuilder = language
            ?.let { contentBuilder.beginCodeBlock(it) }
            ?: contentBuilder.beginCodeBlock()
    val markdownDsl = MarkdownDsl(codeBlockBuilder)
    markdownDsl.applier()
    contentBuilder.append(codeBlockBuilder)
    return markdownDsl
}

fun MarkdownDsl.unorderedList(vararg values: String) {
    contentBuilder.unorderedList(values)
}

fun MarkdownDsl.unorderedList(values: List<String>) {
    contentBuilder.unorderedList(values)
}

fun MarkdownDsl.unorderedList(listBuilder: () -> List<String>) {
    val list = listBuilder()
    unorderedList(list)
}

fun MarkdownDsl.taskList(vararg values: Pair<Boolean, String>) {
    val list = values.map { TaskListItem(it.second, it.first) }
    contentBuilder.taskList(*list.toTypedArray())
}

fun MarkdownDsl.taskList(values: List<Pair<Boolean, String>>) {
    val list = values.map { TaskListItem(it.second, it.first) }
    contentBuilder.taskList(*list.toTypedArray())
}

fun MarkdownDsl.taskList(listBuilder: () -> List<Pair<Boolean, String>>) {
    val list = listBuilder()
    taskList(list)
}

fun MarkdownDsl.newParagraph() {
    contentBuilder.newParagraph()
}

fun MarkdownDsl.newLine() {
    contentBuilder.newLine()
}

fun MarkdownDsl.newLines(count: Int) {
    contentBuilder.newLines(count)
}

fun MarkdownDsl.text(value: String) {
    contentBuilder.append(value)
}

fun MarkdownDsl.bold(value: String) {
    contentBuilder.bold(value)
}

fun MarkdownDsl.italic(value: String) {
    contentBuilder.italic(value)
}

fun MarkdownDsl.strikeThrough(value: String) {
    contentBuilder.strikeThrough(value)
}

fun MarkdownDsl.heading(value: String, level: Int = 1) {
    contentBuilder.heading(value, level)
}

fun MarkdownDsl.subHeading(value: String) {
    contentBuilder.subHeading(value)
}

fun MarkdownDsl.rule(length: Int = 1) {
    contentBuilder.rule(length)
}

fun MarkdownDsl.link(text: String, url: String) {
    contentBuilder.link(text, url)
}

fun MarkdownDsl.link(url: String) {
    contentBuilder.link(url)
}

fun MarkdownDsl.image(text: String, url: String) {
    contentBuilder.link(text, url)
}

fun MarkdownDsl.image(url: String) {
    contentBuilder.link(url)
}

fun MarkdownDsl.progress(progress: Double) {
    contentBuilder.progress(progress)
}

fun MarkdownDsl.progressWithLabel(progress: Double) {
    contentBuilder.progressWithLabel(progress)
}

fun MarkdownDsl.quote(value: String) {
    contentBuilder.quote(value)
}

fun MarkdownDsl.code(value: String) {
    contentBuilder.code(value)
}

fun MarkdownDsl.append(value: String) {
    contentBuilder.append(value)
}

fun MarkdownDsl.append(markdownSerializable: MarkdownSerializable) {
    contentBuilder.append(markdownSerializable)
}

fun MarkdownDsl.append(markdownDsl: MarkdownDsl) {
    contentBuilder.append(markdownDsl.contentBuilder)
}