package com.kryptkode.flashalerts.screens.infodialog.view

import com.kryptkode.flashalerts.screens.common.view.BaseObservableViewMvc
import com.kryptkode.flashalerts.screens.infodialog.Info

abstract class InfoDialogViewMvc : BaseObservableViewMvc<InfoDialogViewMvc.Listener>() {

    interface Listener {
        fun onPositiveButtonClick()
        fun onNeutralButtonClick()
        fun onNegativeButtonClick()
    }

    abstract fun bindInfo(info: Info)

}