package com.github.ilyasyoy.markdown.nodes


interface ListMarkdownNode : MarkdownNode {
    var list: List<CommonListMarkdownNode.ListItemMarkdownNode>
}

data class CommonListMarkdownNode(
    override var list: List<ListItemMarkdownNode>,

    val ordered: Boolean = false,
    val listMode: ListMode = ListMode.DASH
) : ListMarkdownNode {
    override val markdownNodeType: MarkdownNodeType = when (ordered) {
        false -> MarkdownNodeType.UL
        true -> MarkdownNodeType.OL
    }

    override fun render(): String = list.joinToString(System.lineSeparator()) { it.render() }

    fun li(text: String) {
        list = list + ListItemMarkdownNode(text, list.size + 1)
    }

    inner class ListItemMarkdownNode(
        private val text: String,
        private val number: Int,
    ) : MarkdownNode {
        override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.LI

        override fun render(): String = when (this@CommonListMarkdownNode.markdownNodeType) {
            MarkdownNodeType.UL -> "${listMode.symbol} $text"
            MarkdownNodeType.OL -> "${number}. $text"
            else -> error("Wrong list type ($markdownNodeType), cannot be rendered")
        }
    }
}

enum class ListMode(
    val symbol: Char
) {
    DASH('-'),
    ASTERISK('*');

    companion object {
        val DEFAULT: ListMode = DASH
    }
}