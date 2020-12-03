package com.kryptkode.flashalerts.app.di.app.data

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.kryptkode.flashalerts.BuildConfig
import com.kryptkode.flashalerts.app.di.app.ApplicationScope
import com.kryptkode.flashalerts.app.utils.rating.RatingDataProvider
import com.kryptkode.flashalerts.app.utils.rating.RatingDataProviderImpl
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides

@Module
class DataModule {


    @ApplicationScope
    @Provides
    fun provideSharedPrefs(context: Application): SharedPreferences {
        val prefsName = "app_prefs"
        return if (BuildConfig.DEBUG) context.getSharedPreferences(
            prefsName,
            Context.MODE_PRIVATE
        ) else SecurePreferences(context, prefsName)
    }

    @ApplicationScope
    @Provides
    fun provideRatingHelper(sharedPreferences: SharedPreferences): RatingDataProvider {
        return RatingDataProviderImpl(sharedPreferences)
    }
}