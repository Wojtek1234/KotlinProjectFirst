package com.stsg.kotlinprojecttest.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.antonioleiva.weatherapp.ui.utils.supportsLollipop
import com.stsg.kotlinprojecttest.ForecastListAdapter
import com.stsg.kotlinprojecttest.R
import com.stsg.kotlinprojecttest.domain.RequestForecastCommand
import kotlinx.android.synthetic.activity_kotlin.forecastList
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        forecastList.layoutManager= LinearLayoutManager(this)

        async {
            val result = RequestForecastCommand("00544").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) {forecast->toast(forecast.date)}
                supportsLollipop{
                    toast("I am lollipop")
                }
            }
        }
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

}
