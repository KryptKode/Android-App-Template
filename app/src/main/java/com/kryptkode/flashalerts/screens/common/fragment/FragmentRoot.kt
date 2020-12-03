package com.kryptkode.flashalerts.screens.common.fragment

import androidx.fragment.app.Fragment

interface FragmentRoot {
    val numberOfRootFragments: Int
    fun getFragmentRootResId():Int
    fun getRootFragment(index:Int):Fragment
}