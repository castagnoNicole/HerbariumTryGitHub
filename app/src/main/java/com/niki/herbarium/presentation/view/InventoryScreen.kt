package com.niki.herbarium.presentation.view

import com.niki.herbarium.data.Plant
import com.niki.herbarium.presentation.MVP

/**
 * Created by Admin on 2/23/2017.
 */
interface InventoryScreen : MVP.View {
    fun loadPlants(plantList : List<Plant>)


}