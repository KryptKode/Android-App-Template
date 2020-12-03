package com.kryptkode.flashalerts.screens.common.dialog

import com.kryptkode.flashalerts.app.common.BaseObservable

class DialogEventBus : BaseObservable<DialogEventBus.Listener>() {

    interface Listener {
        fun onDialogEvent(event: Any?)
    }

    fun postEvent(event: Any?) {
        onEachListener {
            it.onDialogEvent(event)
        }
    }
}