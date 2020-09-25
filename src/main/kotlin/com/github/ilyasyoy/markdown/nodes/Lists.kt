package com.github.ilyasyoy.markdown.nodes


data class CommonListMarkdownNode(
    override var list: List<ListItemMarkdownNode>,
    val ordered: Boolean = false
) : ListMarkdownNode {
    override val markdownNodeType: MarkdownNodeType = when (ordered) {
        false -> MarkdownNodeType.UL
        true -> MarkdownNodeType.OL
    }

    fun li(text: String) {
        list = list + ListItemMarkdownNode(text)
    }

    fun li(text: String, ordered: Boolean = false, init: CommonListMarkdownNode.() -> Unit) {
        val commonListMarkdownNode = CommonListMarkdownNode(listOf(), ordered)
        commonListMarkdownNode.init()
        list = list + ListItemMarkdownNode(text, commonListMarkdownNode)
    }

}

data class ListItemMarkdownNode(
    val text: String,
    val subList: ListMarkdownNode? = null
) : MarkdownNode {
    override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.LI
}

