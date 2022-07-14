package com.example.sesameassignment

import android.app.Application
import android.content.Context

class BaseApplication: Application() {
    companion object {
        var ctx: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }
}