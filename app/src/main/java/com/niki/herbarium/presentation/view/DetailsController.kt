package com.niki.herbarium.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.niki.herbarium.R

/**
 * Created by Admin on 2/27/2017.
 */

class DetailsController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
            val detailView = inflater.inflate(R.layout.plant_details, container, false) as ViewGroup

        return detailView
    }

}
