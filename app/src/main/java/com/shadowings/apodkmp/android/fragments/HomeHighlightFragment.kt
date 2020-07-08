package com.shadowings.apodkmp.android.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import co.touchlab.kampstarter.android.R
import com.shadowings.apodkmp.android.adapters.ApodAdapter
import com.shadowings.apodkmp.android.utils.Dimens
import com.shadowings.apodkmp.android.utils.Views
import com.shadowings.apodkmp.android.utils.appendBelowWithMarginAndHeight
import com.shadowings.apodkmp.android.utils.bottomStartInParentWithSide
import com.shadowings.apodkmp.android.utils.centerInParentWithMargin
import com.shadowings.apodkmp.home.HomeInteractor

class HomeHighlightFragment : BaseHighlightFragment() {

    private lateinit var title: AppCompatTextView
    private lateinit var latestLabel: AppCompatTextView
    private lateinit var latest: RecyclerView
    private lateinit var logo: AppCompatImageView
    private val homeInteractor: HomeInteractor =
        HomeInteractor()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val set = initViews(context!!)

        logo = Views.buildImage(context!!, View.GONE)
        logo.setBackgroundResource(R.drawable.youtube_logo)
        logo.scaleType = ImageView.ScaleType.CENTER_INSIDE
        logo.alpha = 0F

        title = Views.buildBigText(context!!, Color.WHITE)
        title.gravity = Gravity.TOP

        latestLabel = Views.buildMediumText(context!!, Color.DKGRAY)
        latestLabel.gravity = Gravity.BOTTOM
        latestLabel.text = "Latest:"

        latest = Views.buildHorizontalRecyclerView(context!!)
        latest.adapter = ApodAdapter()

        set.centerInParentWithMargin(title, highlightImage, Dimens.margin)
        set.bottomStartInParentWithSide(logo, highlightImage, 200)
        set.appendBelowWithMarginAndHeight(latestLabel, highlightImage, Dimens.margin, (Dimens.margin + Dimens.textSizeMedium).toInt())
        set.appendBelowWithMarginAndHeight(latest, latestLabel, 0, Dimens.latestCardSize)

        set.connect(latest.id, ConstraintSet.BOTTOM, constraintLayout.id, ConstraintSet.BOTTOM, Dimens.margin)

        with(constraintLayout) {
            addView(highlightImage)
            addView(title)
            addView(logo)
            addView(latestLabel)
            addView(latest)
            setConstraintSet(set)
        }

        scrollView.addView(constraintLayout)

        homeInteractor.subscribe {
            if (activity != null && it.homeState.latest.isNotEmpty()) {
                activity!!.runOnUiThread {
                    val apods = it.homeState.latest

                    (latest.adapter as ApodAdapter).apods = apods.subList(1, apods.size - 1)
                    (latest.adapter as ApodAdapter).notifyDataSetChanged()

                    val apod = apods.first()
                    logo.visibility = View.GONE
                    // logo.visibility = if (apod.media_type == "video") View.VISIBLE else View.GONE
                    title.text = apod.title
                    loadImage(apod.url)
                }
            }
        }

        homeInteractor.init()

        return scrollView
    }
}
