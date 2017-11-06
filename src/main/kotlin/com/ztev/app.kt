package com.ztev

import com.beust.klaxon.JsonArray
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.beust.klaxon.string
import com.ztev.pojo.MenuNode
import java.io.FileInputStream

fun main(args: Array<String>) {


    var jsonParser = Parser()
    val jsonObjs = jsonParser.parse(FileInputStream("menus.json")) as JsonArray<JsonObject>

    val menuNodes = jsonObjs.map {
        MenuNode(id = it.string("id"),
                             name = it.string("parentMenuName"),
                             ifframeUrl = it.string("ifframeUrl"),
                              operation = it.string("opereation"),
                              iconClass = it.string("iconClass"))

    }
    println(menuNodes.javaClass.name)





}

