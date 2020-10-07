package com.github.ilyasyoy.markdown

import org.junit.jupiter.api.Test

internal class MarkdownDslKtTest {

    @Test
    fun markdown() {
        val markdown = markdown {
            heading("MarkDown")

            italic("italic")
            newLine()
            "italic extensions".italic()
            newLine()
            bold("bold")
            newLine()
            "bold extensions".bold()
            newLine()
            strikeThrough("strike through")
            newLine()
            "strike through extensions".strikeThrough()

            newParagraph()
            subHeading("Progress bars")
            text("Here they are: ")
            progress(0.5)
            rule()
            progressWithLabel(0.5)

            subHeading("Links!")
            link("My GitHub", "https://github.com/IlyasYOY")
            newLine()
            image(
                "My Profile Image",
                "https://avatars3.githubusercontent.com/u/18665585?s=460&u=f4668bb4e7de22085ade1fdf0f702a382667e461&v=4"
            )

            subHeading("Codes and quotes")

            text("Empty JSON object: ")
            newLine()
            code("{}")
            newLine()
            "{}".code()

            quote("Be or not to be")

            quote {
                text("be or not to be")
                newLine()
                text("Again?")
            }
            code(language = "java") {
                text("System.out.println();")
            }

            subHeading("Lists!")

            list {
                text("1")
                list {
                    text("sub 1")
                    text("sub 2")
                }
                code("2")
                italic("3")
                "4".bold()
            }

            subHeading("Tasks")
            taskList(
                true to "Do this",
                false to "Do that"
            )

            subHeading("Table")

            table {
                rowLimit(5)
                row("Value", "Square")
                alignment(TableAlignment.ALIGN_CENTER)

                (1..10)
                    .withIndex()
                    .forEach {
                        row(it.index.toString(), (it.value * it.value).toString())
                    }
            }
        }

        println(markdown.render())
    }

}