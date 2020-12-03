package com.kryptkode.flashalerts.screens.common.screennavigator

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kryptkode.flashalerts.screens.common.backpress.BackPressedListener
import com.kryptkode.flashalerts.screens.common.fragment.FragmentRoot
import com.ncapdevi.fragnav.FragNavController

class ScreenNavigator(
    private val fragNavController: FragNavController,
    private val fragmentRoot: FragmentRoot
) : FragNavController.RootFragmentListener, BackPressedListener {


    fun init(savedInstanceState: Bundle?) {
        fragNavController.fragmentHideStrategy = FragNavController.DETACH_ON_NAVIGATE_HIDE_ON_SWITCH
        fragNavController.createEager = true
        fragNavController.rootFragmentListener = this
        fragNavController.initialize(savedInstanceState = savedInstanceState)
    }

    fun onSavedInstanceState(outState: Bundle?) {
        fragNavController.onSaveInstanceState(outState)
    }

    fun toSettingsScreen() {
        fragNavController.switchTab(FragNavController.TAB2)
    }

    fun navigateHome(): Boolean {
        fragNavController.switchTab(FragNavController.TAB1)
        return true
    }

    fun navigateUp() {
        fragNavController.popFragment()
    }

    override fun onBackPressed(): Boolean {
       return false
    }

    override fun getRootFragment(index: Int): Fragment {
        return fragmentRoot.getRootFragment(index)
    }

    override val numberOfRootFragments: Int
        get() = fragmentRoot.numberOfRootFragments


}