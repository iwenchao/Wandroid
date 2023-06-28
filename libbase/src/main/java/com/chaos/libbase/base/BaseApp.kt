package com.chaos.libbase.base

import android.app.Application
import android.content.Context

class BaseApp : Application() {


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)


    }

    override fun onCreate() {
        super.onCreate()
    }
}