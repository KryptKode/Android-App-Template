package com.kryptkode.flashalerts.screens.common.imageloader

import android.widget.ImageView
import com.kryptkode.flashalerts.R
import com.kryptkode.flashalerts.app.customviews.PlaceHolderDrawable
import com.kryptkode.flashalerts.app.utils.GlideApp

class ImageLoaderImpl : ImageLoader {

    override fun load(imageSource: String, target: ImageView) {
     val placeholderDrawable = PlaceHolderDrawable(target.context)

        GlideApp.with(target)
            .load(imageSource)
            .placeholder(placeholderDrawable)
            .error(R.mipmap.ic_launcher)
            .into(target)

    }
}