package com.github.ilyasyoy.markdown.nodes

fun CommonListMarkdownNode.item(text: String) {
    list = list + ListItemMarkdownNode(text, list.size + 1)
}