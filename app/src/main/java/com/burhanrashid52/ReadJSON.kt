package com.burhanrashid52

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class ReadJSON {

    lateinit var list: ArrayList<String>

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
        } catch (ioException: IOException) {}

        val jsonObject = JSONObject(jsonString)

        val jsonLinks = jsonObject.getJSONArray("names")

        return jsonLinks

    }

    fun getLink(context: Context): JSONArray {

        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("json_config.json")
                    .bufferedReader()
                    .use { it.readText() }
        } catch (ioException: IOException) {}

        val jsonObject = JSONObject(jsonString)

        val jsonLinks = jsonObject.getJSONArray("links")

        return jsonLinks

    }

}