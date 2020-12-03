package com.kryptkode.flashalerts.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kryptkode.flashalerts.screens.infodialog.view.InfoDialogViewMvc
import com.kryptkode.flashalerts.screens.infodialog.view.InfoDialogViewMvcImpl
import com.kryptkode.flashalerts.screens.rating.view.RatingView
import com.kryptkode.flashalerts.screens.rating.view.RatingViewImpl

class DialogViewFactory(private val layoutInflater: LayoutInflater) {

    fun getInfoDialogView(): InfoDialogViewMvc {
        return InfoDialogViewMvcImpl(layoutInflater)
    }

    fun getRatingView(parent: ViewGroup?= null): RatingView {
        return RatingViewImpl(layoutInflater, parent)
    }
}