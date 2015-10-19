package com.stsg.kotlinprojecttest.domain

import com.antonioleiva.weatherapp.domain.mappers.ForecastDataMapper
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import com.stsg.kotlinprojecttest.network.ForecastRequest

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
class RequestForecastCommand(val zipCode: Long,
                             val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {
    companion object {
        val DAYS = 7
    }
    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}