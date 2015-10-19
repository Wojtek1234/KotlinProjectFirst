package com.antonioleiva.weatherapp.domain.datasource

import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList


interface ForecastDataSource {
    
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

}