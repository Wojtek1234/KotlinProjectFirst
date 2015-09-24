package com.stsg.kotlinprojecttest.domain

import com.stsg.kotlinprojecttest.date.Forecast
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import com.stsg.kotlinprojecttest.date.ForecastResult
import java.text.DateFormat
import java.util.*
import com.stsg.kotlinprojecttest.domain.domainmodel.Forecast as ModelForcast

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
public class ForecastDataMapper {
    public fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForcast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForcast {
        return ModelForcast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)

    }

    private fun generateIconUrl(iconCode: String): String
            = "http://openweathermap.org/img/w/$iconCode.png"

}
