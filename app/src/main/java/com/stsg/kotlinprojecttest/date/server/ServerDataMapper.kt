package com.antonioleiva.weatherapp.data.server

import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import com.stsg.kotlinprojecttest.domain.domainmodel.Forecast as ModelForecast

class ServerDataMapper {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult): ForecastList = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast = with(forecast) {
        ModelForecast( dt * 1000, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

//    data class Forecast(val date: Long, val description: String, val high: Int, val low: Int,
//                        val iconUrl: String)
    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}