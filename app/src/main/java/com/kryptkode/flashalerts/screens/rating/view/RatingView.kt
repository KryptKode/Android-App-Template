package com.kryptkode.flashalerts.screens.rating.view

import com.kryptkode.flashalerts.screens.common.view.BaseObservableViewMvc

abstract class RatingView : BaseObservableViewMvc<RatingView.Listener>(){
    interface Listener{
        fun onExit()
        fun onCancelExit()
        fun onRateApp(rating:Int)
    }
}