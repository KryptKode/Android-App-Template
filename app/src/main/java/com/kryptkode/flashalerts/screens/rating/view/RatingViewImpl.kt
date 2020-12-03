package com.kryptkode.flashalerts.screens.rating.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kryptkode.flashalerts.databinding.DialogRatingBinding

class RatingViewImpl (
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
) : RatingView() {

    private val binding  = DialogRatingBinding.inflate(layoutInflater, parent, false)

    init {
        initListeners()
    }

    private fun initListeners() {
        binding.btnCancel.setOnClickListener {
            onEachListener {
                it.onCancelExit()
            }
        }

        binding.btnOk.setOnClickListener {
            onEachListener {
                it.onExit()
            }
        }

        binding.ratingBar.setSmileySelectedListener {type->
            onEachListener {
                it.onRateApp(type.rating)
            }
        }
    }


    override val rootView: View
        get() = binding.root
}