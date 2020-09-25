package com.github.ilyasyoy.markdown.nodes

data class HeaderMarkdownNode(
    override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.H1,
    val text: String
) : MarkdownNode {
    companion object {
        fun ofNumber(level: Int, text: String): HeaderMarkdownNode = when (level) {
            1 -> HeaderMarkdownNode(MarkdownNodeType.H1, text = text)
            2 -> HeaderMarkdownNode(MarkdownNodeType.H2, text = text)
            3 -> HeaderMarkdownNode(MarkdownNodeType.H3, text = text)
            4 -> HeaderMarkdownNode(MarkdownNodeType.H4, text = text)
            5 -> HeaderMarkdownNode(MarkdownNodeType.H5, text = text)
            6 -> HeaderMarkdownNode(MarkdownNodeType.H6, text = text)
            else -> error("Header number must be >= 0 and ,+ 6")
        }
    }
}
