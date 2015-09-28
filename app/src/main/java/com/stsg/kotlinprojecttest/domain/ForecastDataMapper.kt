package com.antonioleiva.weatherapp.domain.mappers

import com.stsg.kotlinprojecttest.date.Forecast
import com.stsg.kotlinprojecttest.date.ForecastResult
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import com.stsg.kotlinprojecttest.domain.domainmodel


class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult): ForecastList = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<domainmodel.Forecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast:Forecast): domainmodel.Forecast = with(forecast) {
        domainmodel.Forecast(dt * 1000, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}