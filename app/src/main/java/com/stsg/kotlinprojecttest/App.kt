package com.stsg.kotlinprojecttest

import android.app.Application
import com.antonioleiva.weatherapp.ui.utils.DelegatesExt

/**
 * Created by wojtek on 24.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
