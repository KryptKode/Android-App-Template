package com.kryptkode.flashalerts.app.di.controller

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.kryptkode.flashalerts.app.utils.ToastHelper
import com.kryptkode.flashalerts.app.utils.inappupdates.InAppUpdateChecker
import com.kryptkode.flashalerts.screens.common.DialogViewFactory
import com.kryptkode.flashalerts.screens.common.ViewFactory
import com.kryptkode.flashalerts.screens.common.backpress.BackPressDispatcher
import com.kryptkode.flashalerts.screens.common.dialog.DialogEventBus
import com.kryptkode.flashalerts.screens.common.fragment.FragmentRoot
import com.kryptkode.flashalerts.screens.common.imageloader.ImageLoader
import com.kryptkode.flashalerts.screens.common.screennavigator.ScreenNavigator
import com.kryptkode.flashalerts.screens.common.screennavigator.ActivityScreenNavigator
import com.ncapdevi.fragnav.FragNavController
import dagger.Module
import dagger.Provides

/**
 * Created by kryptkode on 5/21/2020.
 */
@Module
class ControllerModule(
    private val activity: AppCompatActivity,
    private val fragmentManager: FragmentManager
) {
    @Provides
    @ControllerScope
    fun context(): Context {
        return activity
    }

    @Provides
    @ControllerScope
    fun activity(): AppCompatActivity {
        return activity
    }

    @Provides
    @ControllerScope
    fun fragmentManager(): FragmentManager {
        return fragmentManager
    }

    @Provides
    @ControllerScope
    fun layoutInflater(): LayoutInflater {
        return activity.layoutInflater
    }

    @Provides
    @ControllerScope
    fun viewFactory(
        imageLoader: ImageLoader,
        layoutInflater: LayoutInflater
    ): ViewFactory {
        return ViewFactory(
            imageLoader,
            layoutInflater
        )
    }

    @Provides
    @ControllerScope
    fun dialogViewFactory(
        layoutInflater: LayoutInflater
    ): DialogViewFactory {
        return DialogViewFactory(
            layoutInflater
        )
    }

    @Provides
    @ControllerScope
    fun dialogEventBus(): DialogEventBus {
        return DialogEventBus()
    }

    @Provides
    @ControllerScope
    fun fragNavController(
        fragmentManager: FragmentManager,
        fragmentRoot: FragmentRoot
    ): FragNavController {
        return FragNavController(fragmentManager, fragmentRoot.getFragmentRootResId())
    }

    @Provides
    @ControllerScope
    fun provideBackPressDispatcher(): BackPressDispatcher {
        return activity as BackPressDispatcher
    }

    @Provides
    @ControllerScope
    fun fragmentRoot(): FragmentRoot {
        return activity as FragmentRoot
    }

    @Provides
    @ControllerScope
    fun screenNavigator(
        fragNavController: FragNavController,
        fragmentRoot: FragmentRoot
    ): ScreenNavigator {
        return ScreenNavigator(fragNavController, fragmentRoot)
    }

    @Provides
    @ControllerScope
    fun activityScreenNavigator(
        context: Context
    ): ActivityScreenNavigator {
        return ActivityScreenNavigator(context)
    }

    @Provides
    @ControllerScope
    fun provideInAppUpdateChecker(
        appToastCreator: ToastHelper,
        activity: AppCompatActivity
    ): InAppUpdateChecker {
        return InAppUpdateChecker(appToastCreator, activity)
    }

}