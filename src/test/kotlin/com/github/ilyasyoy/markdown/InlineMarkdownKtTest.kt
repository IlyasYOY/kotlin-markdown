package com.github.ilyasyoy.markdown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InlineMarkdownKtTest {

    @Test
    fun boldEmpty() {
        assertEquals("", "".b())
    }

    @Test
    fun italicEmpty() {
        assertEquals("", "".i())
    }

    @Test
    fun monoEmpty() {
        assertEquals("", "".mono())
    }

    @Test
    fun bold() {
        assertEquals("**1**", "1".b(mode = EmphasisMode.ASTERISK))
    }

    @Test
    fun italic() {
        assertEquals("_1_", "1".i(mode = EmphasisMode.UNDERSCORE))
    }

    @Test
    fun mono() {
        assertEquals("`1`", "1".mono())
    }

    @Test
    fun boldIdempotent() {
        assertEquals("__1__", "1".b().bold())
    }

    @Test
    fun italicIdempotent() {
        assertEquals("_1_", "1".i().italic())
    }

    @Test
    fun monoIdempotent() {
        assertEquals("`1`", "1".mono().code())
    }

    @Test
    fun testLink() {
        val link = "https://github.com/IlyasYOY/kotlin-markdown"
        assertEquals(
            "[My GitHub](https://github.com/IlyasYOY/kotlin-markdown)",
            "My GitHub".link(link)
        )
    }

    fun testImage() {
        val image =
            "https://avatars3.githubusercontent.com/u/18665585?s=460&u=f4668bb4e7de22085ade1fdf0f702a382667e461&v=4"
        assertEquals(
            "![My GitHub Image](https://avatars3.githubusercontent.com/u/18665585?s=460&u=f4668bb4e7de22085ade1fdf0f702a382667e461&v=4)",
            "My GitHub Image".image(image)
        )
    }
}