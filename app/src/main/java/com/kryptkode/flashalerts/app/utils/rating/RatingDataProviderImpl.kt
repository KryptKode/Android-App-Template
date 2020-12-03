package com.kryptkode.flashalerts.app.utils.rating

import android.content.SharedPreferences
import com.kryptkode.flashalerts.app.utils.rating.RatingDataProvider.Companion.DEFAULT_LONG

class RatingDataProviderImpl(sharedPreferences: SharedPreferences) : RatingDataProvider {

    override fun setAgreeShowDialog(isAgree: Boolean) {

    }

    override fun getIsAgreeShowDialog(): Boolean {
        return false
    }

    override fun setRemindInterval(timeStamp: Long) {

    }

    override fun getRemindInterval(): Long {
        return 0
    }

    override fun setInstallDate(timeStamp: Long) {

    }

    override fun getInstallDate(): Long {
        return 0
    }

    override fun setLaunchTimes(launchTimes: Int) {

    }

    override fun getLaunchTimes(): Int {
        return 0
    }

    companion object {
        private const val PREF_KEY_INSTALL_DATE = "android_rate_install_date"
        private const val PREF_KEY_LAUNCH_TIMES = "android_rate_launch_times"
        private const val PREF_KEY_IS_AGREE_SHOW_DIALOG = "android_rate_is_agree_show_dialog"
        private const val PREF_KEY_REMIND_INTERVAL = "android_rate_remind_interval"
    }
}