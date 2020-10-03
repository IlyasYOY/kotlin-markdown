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

    override fun render(): String = this.toString()

    override fun toString(): String {
        val repeatTimes = when (markdownNodeType) {
            MarkdownNodeType.H1 -> 1
            MarkdownNodeType.H2 -> 2
            MarkdownNodeType.H3 -> 3
            MarkdownNodeType.H4 -> 4
            MarkdownNodeType.H5 -> 5
            MarkdownNodeType.H6 -> 6
            else -> error("Header number must be >= 0 and ,+ 6")
        }

        return "${"#".repeat(repeatTimes)} $text"
    }
}
