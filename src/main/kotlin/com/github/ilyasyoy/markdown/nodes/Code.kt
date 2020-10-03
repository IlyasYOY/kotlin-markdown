package com.github.ilyasyoy.markdown.nodes

data class CodeMarkdownNode(
    override val markdownNodeType: MarkdownNodeType = MarkdownNodeType.CODE,
    val type: String = "",
    val text: String
) : MarkdownNode {
    override fun render(): String = """
        |```$type
        |$text
        |```
    """.trimMargin()

}
