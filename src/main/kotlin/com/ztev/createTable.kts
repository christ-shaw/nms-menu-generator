package com.ztev



open class Tag(val name: String)
{
    private val children = mutableListOf<Tag>()
    protected fun<T : Tag> doInit(child : T , init : T.() -> Unit)
    {
        child.init()
        children.add(child)

    }

    override fun toString() =
            "<$name>${children.joinToString("")}</$name>"


}
class Table : Tag("table")
{
    fun tr(init: Tr.() -> Unit) = doInit(Tr(), init)
}

class Tr : Tag("tr")
{
    fun td(init: Td.() -> Unit) = doInit(Td(), init)
}

class Td : Tag("td")


fun createTable() =
        table {
            tr {
                td {
                }
            }
        }

println(createTable())

fun table(init: Table.() -> Unit) =
        Table().apply(init)

fun buildString(block: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    builder.block()
    builder.appendExcl()
    return builder.toString()
}

val appendExcl : StringBuilder.() -> Unit =
        {
            append("!")
        }



println(buildString{ append("a")
    append("b")})