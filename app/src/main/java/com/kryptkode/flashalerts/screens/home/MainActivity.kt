package com.kryptkode.flashalerts.screens.home

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.kryptkode.flashalerts.R
import com.kryptkode.flashalerts.app.common.Constants
import com.kryptkode.flashalerts.app.logger.Logger
import com.kryptkode.flashalerts.app.utils.NetworkListener
import com.kryptkode.flashalerts.app.utils.SendEmailUtil
import com.kryptkode.flashalerts.app.utils.ToastHelper
import com.kryptkode.flashalerts.app.utils.share.PlayStoreUtils
import com.kryptkode.flashalerts.app.utils.share.ShareUtils
import com.kryptkode.flashalerts.screens.common.activity.BaseActivity
import com.kryptkode.flashalerts.screens.common.backpress.BackPressDispatcher
import com.kryptkode.flashalerts.screens.common.backpress.BackPressedListener
import com.kryptkode.flashalerts.screens.common.dialog.DialogEventBus
import com.kryptkode.flashalerts.screens.common.dialog.DialogManager
import com.kryptkode.flashalerts.screens.common.fragment.FragmentRoot
import com.kryptkode.flashalerts.screens.common.screennavigator.ScreenNavigator
import com.kryptkode.flashalerts.app.utils.inappupdates.InAppUpdateChecker
import com.kryptkode.flashalerts.app.utils.rating.RatingManager
import com.kryptkode.flashalerts.screens.rating.event.ExitAppEvent
import com.kryptkode.flashalerts.screens.rating.event.RatingEvent
import javax.inject.Inject

class MainActivity : BaseActivity(), FragmentRoot, BackPressDispatcher, DialogEventBus.Listener{


    @Inject
    lateinit var screenNavigator: ScreenNavigator

    @Inject
    lateinit var logger: Logger


    @Inject
    lateinit var dialogManager: DialogManager

    @Inject
    lateinit var dialogEventBus: DialogEventBus

    @Inject
    lateinit var ratingManager: RatingManager

    @Inject
    lateinit var shareUtils: ShareUtils

    @Inject
    lateinit var playStoreUtils: PlayStoreUtils

    @Inject
    lateinit var toastHelper: ToastHelper

    @Inject
    lateinit var networkListener: NetworkListener

    @Inject
    lateinit var inAppUpdateChecker: InAppUpdateChecker

    @Inject
    lateinit var sendEmailUtil: SendEmailUtil

    private var doubleBackToExitPressedOnce = false

    private val backPressedListeners = mutableSetOf<BackPressedListener>()

    override val numberOfRootFragments: Int
        get() = 4

    init {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        controllerComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        registerListener(screenNavigator)
        dialogEventBus.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        unregisterListener(screenNavigator)
        dialogEventBus.unregisterListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        screenNavigator.onSavedInstanceState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        inAppUpdateChecker.onActivityResult(requestCode, resultCode)
        for (fragment in supportFragmentManager.fragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun getFragmentRootResId(): Int {
        return R.id.fragment_root
    }

    override fun getRootFragment(index: Int): Fragment {
        return when (index) {
            else -> HomeFragment()
        }
    }

    override fun registerListener(listener: BackPressedListener) {
        backPressedListeners.add(listener)
    }

    override fun unregisterListener(listener: BackPressedListener) {
        backPressedListeners.remove(listener)
    }

    override fun onBackPressed() {
        var isBackPressConsumedByAnyListener = false
        for (listener in backPressedListeners) {
            if (listener.onBackPressed()) {
                isBackPressConsumedByAnyListener = true
            }
        }
        if (!isBackPressConsumedByAnyListener) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
            }
            doubleBackToExitPressedOnce = true
            toastHelper.showMessage(getString(R.string.press_to_exit))
            Handler()
                .postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onDialogEvent(event: Any?) {
        when (event) {
            is ExitAppEvent -> {

            }

            is RatingEvent -> {
                val rating = event.rating
                if (rating > 3) {
                    playStoreUtils.openPlayStore()
                } else {
                    sendEmailUtil.sendEmail(Constants.FEEDBACK_EMAIL, getString(R.string.contact_us_hint))
                }
            }
        }
    }
}
