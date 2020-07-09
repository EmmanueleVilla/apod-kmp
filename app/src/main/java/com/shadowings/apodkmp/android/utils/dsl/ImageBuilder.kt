package com.shadowings.apodkmp.android.utils.dsl

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import org.koin.core.KoinComponent
import org.koin.core.get

class ImageBuilder {
    fun build(
        drawable: Int?,
        width: Int,
        height: Int
    ): AppCompatImageView {
        val container = object : KoinComponent {
            val ctx: Context = get()
        }
        val image = AppCompatImageView(container.ctx)
        image.id = View.generateViewId()
        if (drawable != null) {
            image.setBackgroundResource(drawable)
        }
        image.layoutParams = ViewGroup.LayoutParams(width, height)
        return image
    }
}