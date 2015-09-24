package com.antonioleiva.weatherapp.ui.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View

 val View.ctx: Context
    get() = getContext()

inline fun Activity.supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }