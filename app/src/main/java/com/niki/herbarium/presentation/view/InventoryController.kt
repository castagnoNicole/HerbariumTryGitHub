package com.niki.herbarium.presentation.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.niki.herbarium.Inventory
import com.niki.herbarium.R
import com.niki.herbarium.data.Plant
import com.niki.herbarium.presentation.PlantAdapter
import com.niki.herbarium.presentation.presenter.InventoryPresenter


/**
 * Created by Admin on 2/21/2017.
 */


class InventoryController : Controller(), InventoryScreen {



    private val adapter = PlantAdapter {plant -> showPlantDetails(plant) } //plant -> plant

    override fun loadPlants(plantList: List<Plant>) {
        adapter.plantsInventory = plantList
        adapter.notifyDataSetChanged() //notifica all'adapter che i dati sono cambiati
    }

    private val presenter: InventoryPresenter = InventoryPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        presenter.view = this
        val recyView = inflater.inflate(R.layout.recyclerview_plants, container, false) as RecyclerView
        recyView.layoutManager = LinearLayoutManager(container.context, LinearLayoutManager.VERTICAL, false)
        recyView.adapter = adapter

        presenter.viewIsReady()


        return recyView
    }

    fun showPlantDetails(plant: Plant) {
        val nameClickedPlan : String = plant.name
       router.pushController(RouterTransaction.with(DetailsController()))


    }

}




