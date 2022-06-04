package com.burhanrashid52

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.collections.ArrayList

class ReadJSON {

    fun getColor(context: Context): String{
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("json_config.json")
                    .bufferedReader()
                    .use { it.readText() }
        } catch (ioException: IOException) {}
        val jsonObject = JSONObject(jsonString)
        return jsonObject.get("color").toString()
    }

    fun getNames(context: Context): JSONArray {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("json_config.json")
                    .bufferedReader()
                    .use { it.readText() }
        } catch (ioException: IOException) {
        }

        val jsonObject = JSONObject(jsonString)
        return jsonObject.getJSONArray("names")

    }

    fun getLink(context: Context): JSONArray {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("json_config.json")
                    .bufferedReader()
                    .use { it.readText() }
        } catch (ioException: IOException) {
        }
        val jsonObject = JSONObject(jsonString)
        return jsonObject.getJSONArray("links")

    }

}