# kotlin-markdown
Type-Safe MD Builder for Kotlin  
Powered By [Java-Markdown-Generator](https://github.com/Steppschuh/Java-Markdown-Generator)

Example:

```kotlin
markdown {
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
        alignment(TableAlignment.ALIGN_CENTER)
        row("Value", "Square")
        (1..10)
            .withIndex()
            .forEach {
                row(it.index.toString(), (it.value * it.value).toString())
            }
    }
}
```

Rendered MD:

```markdown
MarkDown
========

_italic_
_italic extensions_
**bold**
**bold extensions**
~~strike through~~
~~strike through extensions~~

Progress bars
-------------

Here they are: [==========----------]
---
[==========----------] ( 50%)

Links!
------

[My GitHub](https://github.com/IlyasYOY)
[My Profile Image](https://avatars3.githubusercontent.com/u/18665585?s=460&u=f4668bb4e7de22085ade1fdf0f702a382667e461&v=4)

Codes and quotes
----------------

Empty JSON object: 
`{}`
`{}`

> Be or not to be

> be or not to be
> Again?

// Commented cause it beaks rendering
//```java 
//System.out.println();
//```

Lists!
------

- 1
  - sub 1
  - sub 2
- `2`
- _3_
- **4**

Tasks
-----

- [x] Do this
- [ ] Do that

Table
-----

| Value | Square |
|:-----:|:------:|
|   0   |   1    |
|   1   |   4    |
| ~~~~~ | ~~~~~~ |
|   8   |   81   |
|   9   |  100   |
```

Rendered MD:

MarkDown
========

_italic_
_italic extensions_
**bold**
**bold extensions**
~~strike through~~
~~strike through extensions~~

Progress bars
-------------

Here they are: [==========----------]
---
[==========----------] ( 50%)

Links!
------

[My GitHub](https://github.com/IlyasYOY)
[My Profile Image](https://avatars3.githubusercontent.com/u/18665585?s=460&u=f4668bb4e7de22085ade1fdf0f702a382667e461&v=4)

Codes and quotes
----------------

Empty JSON object: 
`{}`
`{}`

> Be or not to be

> be or not to be
> Again?

```java
System.out.println();
```

Lists!
------

- 1
  - sub 1
  - sub 2
- `2`
- _3_
- **4**

Tasks
-----

- [x] Do this
- [ ] Do that

Table
-----

| Value | Square |
|:-----:|:------:|
|   0   |   1    |
|   1   |   4    |
| ~~~~~ | ~~~~~~ |
|   8   |   81   |
|   9   |  100   |