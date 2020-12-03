package com.kryptkode.flashalerts.app.utils.rating

import java.util.*
import javax.inject.Inject


class RatingManager @Inject constructor(private val dataProvider: RatingDataProvider) {

    private var installDate = 10

    private var launchTimes = 10

    private var remindInterval = 1

    private var isDebug = false

    fun showRateIfMeetsConditions(): Boolean {
        return isDebug || shouldShowRateDialog()
    }

    fun monitor() {
        if (dataProvider.isFirstLaunch()) {
            dataProvider.setInstallDate(Date().time)
        }
        dataProvider.setLaunchTimes(dataProvider.getLaunchTimes() + 1)
    }

    fun setLaunchTimes(launchTimes: Int): RatingManager {
        this.launchTimes = launchTimes
        return this
    }

    fun setInstallDays(installDate: Int): RatingManager {
        this.installDate = installDate
        return this
    }

    fun setRemindInterval(remindInterval: Int): RatingManager {
        this.remindInterval = remindInterval
        return this
    }

    fun setAgreeShowDialog(agreed: Boolean): RatingManager {
        dataProvider.setAgreeShowDialog(agreed)
        return this
    }

    private fun shouldShowRateDialog(): Boolean {
        return dataProvider.getIsAgreeShowDialog() &&
                isOverLaunchTimes() &&
                isOverInstallDate() &&
                isOverRemindDate()
    }

    private fun isOverLaunchTimes(): Boolean {
        return dataProvider.getLaunchTimes() >= launchTimes
    }

    private fun isOverInstallDate(): Boolean {
        return isOverDate(dataProvider.getInstallDate(), installDate)
    }

    private fun isOverRemindDate(): Boolean {
        return isOverDate(dataProvider.getRemindInterval(), remindInterval)
    }

    private fun isOverDate(targetDate: Long, threshold: Int): Boolean {
        return Date().time - targetDate >= threshold * 24 * 60 * 60 * 1000
    }

    fun isDebug(): Boolean {
        return isDebug
    }

    fun setDebug(isDebug: Boolean): RatingManager {
        this.isDebug = isDebug
        return this
    }
}