package com.kryptkode.flashalerts.app.utils.rating

/**
 * Created by kryptkode on 2/11/2020.
 */
interface RatingDataProvider {
    fun setAgreeShowDialog(isAgree: Boolean)
    fun getIsAgreeShowDialog(): Boolean
    fun setRemindInterval(timeStamp: Long)
    fun getRemindInterval(): Long
    fun setInstallDate(timeStamp: Long)
    fun getInstallDate(): Long
    fun setLaunchTimes(launchTimes: Int)
    fun getLaunchTimes(): Int
    fun isFirstLaunch(): Boolean {
        return getInstallDate() == DEFAULT_LONG
    }

    companion object {
        const val DEFAULT_LONG = -1L
    }
}