package com.week04.test04.models

import lombok.Getter
import org.json.JSONObject

@Getter
class ItemDto(itemJson: JSONObject) {
    private val title: String
    private val link: String
    private val image: String
    private val lprice: Int

    init {
        title = itemJson.getString("title")
        link = itemJson.getString("link")
        image = itemJson.getString("image")
        lprice = itemJson.getInt("lprice")
    }
}