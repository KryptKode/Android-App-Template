package com.kryptkode.flashalerts.screens.common.dialog

import androidx.fragment.app.DialogFragment
import com.kryptkode.flashalerts.app.di.controller.ControllerComponent
import com.kryptkode.flashalerts.screens.common.activity.BaseActivity

abstract class BaseDialog : DialogFragment() {
    val controllerComponent: ControllerComponent by lazy {
        (activity as BaseActivity).controllerComponent
    }
}