package com.stsg.kotlinprojecttest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.antonioleiva.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import com.stsg.kotlinprojecttest.domain.domainmodel.Forecast
import com.stsg.kotlinprojecttest.domain.domainmodel.ForecastList
import kotlinx.android.synthetic.item_forecast.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.onClick


/**
 * Created by wojtek on 17.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */


class ForecastListAdapter(val weekForcast: ForecastList
                          , val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ForecastListAdapter.ViewHolder {
        val view = parent.ctx.layoutInflater.inflate(R.layout.item_forecast,
                parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ForecastListAdapter.ViewHolder,
                                  position: Int) {

        holder.bindViewHolder(weekForcast[position])

    }

    override fun getItemCount(): Int = weekForcast.size()


    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) :
            RecyclerView.ViewHolder(view) {


        fun bindViewHolder(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}￿￿"
                itemView.minTemperature.text = "${low.toString()}￿￿"
                itemView.onClick { itemClick(forecast) }
            }

        }
    }
}
