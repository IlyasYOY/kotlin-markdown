package com.github.ilyasyoy.markdown.nodes

fun Markdown.h1(text: String) {
    h(1, text)
}

fun Markdown.h2(text: String) {
    h(2, text)
}

fun Markdown.h3(text: String) {
    h(3, text)
}

fun Markdown.h4(text: String) {
    h(4, text)
}

fun Markdown.h5(text: String) {
    h(5, text)
}

fun Markdown.text(text: String) {
    nodes = nodes + object : MarkdownNode {
        override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.TEXT
        override fun render(): String = text
    }
}

fun Markdown.code(text: String, type: String = "") {
    nodes = nodes + CodeMarkdownNode(type = type, text = text)
}


fun Markdown.list(
    ordered: Boolean = false,
    init: CommonListMarkdownNode.() -> Unit
): CommonListMarkdownNode =
    when (ordered) {
        true -> ol(init)
        false -> ul(init)
    }

fun Markdown.h6(text: String) {
    h(6, text)
}

fun Markdown.br(times: Int = 0) {
    this.text(System.lineSeparator().repeat(times))
}