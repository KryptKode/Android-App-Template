
package com.kryptkode.flashalerts.screens.common.imageloader

import android.widget.ImageView

interface ImageLoader {
  fun load(imageSource: String, target: ImageView)
}