package com.github.ilyasyoy.markdown.nodes

interface MarkdownNode {
    val markdownNodeType: MarkdownNodeType
}

interface ListMarkdownNode : MarkdownNode {
    var list: List<ListItemMarkdownNode>
}

enum class MarkdownNodeType {
    // Root
    MARKDOWN,

    // Headers
    H1, H2, H3, H4, H5, H6,

    // Lists
    UL, OL, LI
}

