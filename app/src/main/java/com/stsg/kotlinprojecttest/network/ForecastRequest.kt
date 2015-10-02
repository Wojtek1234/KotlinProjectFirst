package com.stsg.kotlinprojecttest.network

import com.google.gson.Gson
import com.stsg.kotlinprojecttest.date.ForecastResult

import java.net.URL

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
*/

class ForecastRequest(val zipCode: Long) {

    companion object {
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}