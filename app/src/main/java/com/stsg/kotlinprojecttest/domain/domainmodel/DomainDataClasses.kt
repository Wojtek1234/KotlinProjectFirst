package com.stsg.kotlinprojecttest.domain.domainmodel

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size()
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)


