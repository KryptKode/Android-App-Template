package com.kryptkode.flashalerts.screens.common.screennavigator

import android.content.Context
import com.kryptkode.flashalerts.screens.home.MainActivity

class ActivityScreenNavigator(
    private val context: Context
) {

    fun toMainScreen() {
        MainActivity.start(context)
    }
}