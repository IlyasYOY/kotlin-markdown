package com.github.ilyasyoy.markdown.nodes

class Markdown : MarkdownNode {
    private var nodes: List<MarkdownNode> = listOf()

    override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.MARKDOWN

    fun h(level: Int, text: String) {
        val headerMarkDownNode = HeaderMarkdownNode.ofNumber(level, text)
        nodes = nodes + headerMarkDownNode
    }

    fun ul(
        init: CommonListMarkdownNode.() -> Unit
    ): CommonListMarkdownNode {
        val unorderedListMarkdownNode = CommonListMarkdownNode(listOf(), false)
        unorderedListMarkdownNode.init()
        return unorderedListMarkdownNode
    }

    fun ol(
        init: CommonListMarkdownNode.() -> Unit
    ): CommonListMarkdownNode {
        val unorderedListMarkdownNode = CommonListMarkdownNode(listOf(), true)
        unorderedListMarkdownNode.init()
        return unorderedListMarkdownNode
    }
}

fun markdown(init: Markdown.() -> Unit): Markdown {
    val markdown = Markdown()
    markdown.init()
    return markdown
}

