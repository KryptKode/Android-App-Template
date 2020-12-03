package com.kryptkode.flashalerts.screens.rating

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kryptkode.flashalerts.app.logger.Logger
import com.kryptkode.flashalerts.screens.common.DialogViewFactory
import com.kryptkode.flashalerts.screens.common.dialog.BaseDialog
import com.kryptkode.flashalerts.screens.common.dialog.DialogEventBus
import com.kryptkode.flashalerts.screens.rating.event.ExitAppEvent
import com.kryptkode.flashalerts.screens.rating.event.RatingEvent
import com.kryptkode.flashalerts.screens.rating.view.RatingView
import javax.inject.Inject

class RatingDialog : BaseDialog(), RatingView.Listener {

    @Inject
    lateinit var dialogViewFactory: DialogViewFactory

    @Inject
    lateinit var dialogEventBus: DialogEventBus

    @Inject
    lateinit var logger: Logger

    private lateinit var viewMvc: RatingView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        controllerComponent.inject(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        viewMvc = dialogViewFactory.getRatingView()
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(viewMvc.rootView)
        return dialog.create()
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
    }

    override fun onExit() {
        dialogEventBus.postEvent(ExitAppEvent())
        dismiss()
    }

    override fun onCancelExit() {
        dismiss()
    }

    override fun onRateApp(rating: Int) {
        dialogEventBus.postEvent(RatingEvent(rating))
    }

    companion object {
        fun newInstance():RatingDialog{
            return RatingDialog()
        }
    }

}