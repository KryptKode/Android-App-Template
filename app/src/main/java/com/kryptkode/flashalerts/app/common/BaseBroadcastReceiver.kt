package com.kryptkode.flashalerts.app.common

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.kryptkode.flashalerts.app.App
import com.kryptkode.flashalerts.app.di.app.ApplicationComponent

abstract class BaseBroadcastReceiver : BroadcastReceiver() {

    private lateinit var appComponent: ApplicationComponent

    override fun onReceive(context: Context?, intent: Intent?) {
        appComponent = (context!!.applicationContext as App).applicationComponent
    }

    protected fun getAppComponent(): ApplicationComponent {
        return appComponent
    }
}
