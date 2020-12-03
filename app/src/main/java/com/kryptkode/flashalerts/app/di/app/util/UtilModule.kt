package com.kryptkode.flashalerts.app.di.app.util

import android.app.Application
import com.kryptkode.flashalerts.app.di.app.ApplicationScope
import com.kryptkode.flashalerts.app.utils.NetworkListener
import com.kryptkode.flashalerts.app.utils.ToastHelper
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    @ApplicationScope
    fun provideToastHelper(application:Application): ToastHelper {
        return ToastHelper(application)
    }

    @Provides
    @ApplicationScope
    fun provideNetworkListener(application:Application): NetworkListener {
        return NetworkListener(application)
    }
}