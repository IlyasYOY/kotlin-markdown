package com.github.ilyasyoy.markdown.nodes

class Markdown : MarkdownNode {
    var nodes: List<MarkdownNode> = listOf()

    override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.MARKDOWN

    override fun render(): String = nodes.joinToString(System.lineSeparator()) { it.render() }

    fun h(level: Int, text: String) {
        val headerMarkDownNode = HeaderMarkdownNode.ofNumber(level, text)
        nodes = nodes + headerMarkDownNode
    }

    fun ul(
        init: CommonListMarkdownNode.() -> Unit
    ): CommonListMarkdownNode {
        val unorderedListMarkdownNode = CommonListMarkdownNode(listOf(), false)
        unorderedListMarkdownNode.init()
        nodes = nodes + unorderedListMarkdownNode
        return unorderedListMarkdownNode
    }

    fun ol(
        init: CommonListMarkdownNode.() -> Unit
    ): CommonListMarkdownNode {
        val orderedListMarkdownNode = CommonListMarkdownNode(listOf(), true)
        orderedListMarkdownNode.init()
        nodes = nodes + orderedListMarkdownNode
        return orderedListMarkdownNode
    }
}

fun markdown(init: Markdown.() -> Unit): Markdown {
    val markdown = Markdown()
    markdown.init()
    return markdown
}

