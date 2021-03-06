package com.stsg.kotlinprojecttest.domain

import com.antonioleiva.weatherapp.data.db.ForecastDb
import com.antonioleiva.weatherapp.data.server.ForecastServer
import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import com.antonioleiva.weatherapp.extensions.firstResult
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import java.util.*

/**
 * Created by wojtek on 19.10.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList
            = sources firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }


    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS


}