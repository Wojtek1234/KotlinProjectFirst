package com.stsg.kotlinprojecttest.domain

import com.antonioleiva.weatherapp.domain.mappers.ForecastDataMapper
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import com.stsg.kotlinprojecttest.network.ForecastRequest

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
class RequestForecastCommand(private val zipCode: Long) :
        Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode,
                forecastRequest.execute())
    }
}
