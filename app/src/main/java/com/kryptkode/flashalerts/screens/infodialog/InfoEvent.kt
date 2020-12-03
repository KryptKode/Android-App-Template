package com.kryptkode.flashalerts.screens.infodialog

data class InfoEvent(val button: Button, val payload:String = "") {
    enum class Button {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }
}