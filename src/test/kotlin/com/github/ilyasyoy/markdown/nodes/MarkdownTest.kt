package com.github.ilyasyoy.markdown.nodes

import com.github.ilyasyoy.markdown.bold
import com.github.ilyasyoy.markdown.italic
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarkdownTest {
    @Test
    fun testMarkdown() {
        val render = markdown {
            h1("Hello Markdown!")
            text("Hello, this is my first markdown rendered!")
            br()
            h2("Unordered List")
            ul {
                li("First Item! Wanna this italic".italic())
                li("Second Item! Wanna this bold".bold())
            }
            h2("Ordered List")
            ol {
                li("First item!")
            }
        }.render()

        assertThat(render).isEqualTo(
            """
            |# Hello Markdown!
            |Hello, this is my first markdown rendered!
            |
            |## Unordered List
            |- _First Item! Wanna this italic_
            |- __Second Item! Wanna this bold__
            |## Ordered List
            |1. First item!""".trimMargin()
        )
    }
}