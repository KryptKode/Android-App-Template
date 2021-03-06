package com.kryptkode.flashalerts.screens.common.fragment

import android.view.View
import androidx.fragment.app.Fragment
import com.kryptkode.flashalerts.app.di.controller.ControllerComponent
import com.kryptkode.flashalerts.screens.common.activity.BaseActivity

/**
 * Created by kryptkode on 5/21/2020.
 */
abstract class BaseFragment(layoutResId:Int = View.NO_ID) : Fragment(layoutResId) {
    val controllerComponent: ControllerComponent by lazy {
        (activity as BaseActivity).controllerComponent
    }
}