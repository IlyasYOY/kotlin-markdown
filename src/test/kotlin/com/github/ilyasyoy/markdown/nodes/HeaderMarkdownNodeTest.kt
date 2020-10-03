package com.github.ilyasyoy.markdown.nodes

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class HeaderMarkdownNodeTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 0, 8, 1030])
    fun testHeaders(number: Int) {
        if (number > 6 || number < 1) {
            assertThrows(IllegalStateException::class.java) {
                val markdownNode = HeaderMarkdownNode.ofNumber(number, "Hello World!")
            }
        } else {
            val markdownNode = HeaderMarkdownNode.ofNumber(number, "Hello World!")
            assertThat(markdownNode.render())
                .startsWith("#".repeat(number))
                .endsWith("Hello World!")
        }
    }
}