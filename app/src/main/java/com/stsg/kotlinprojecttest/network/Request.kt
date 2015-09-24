package com.stsg.kotlinprojecttest.network

import android.util.Log
import java.net.URL

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */


 class Request(val url: String) {
    public fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.getSimpleName(), forecastJsonStr)
    }
}
