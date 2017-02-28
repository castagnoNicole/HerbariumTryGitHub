package com.niki.herbarium.presentation


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.niki.herbarium.R
import com.niki.herbarium.data.Plant


/**
 * Created by Admin on 2/22/2017.
 */





class PlantAdapter(val onPlantSelected : (Plant) -> Unit) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    //var onPlantSelected: ((Plant) -> Unit) ? = null

    var plantsInventory : List<Plant> = listOf()


    //riusa le viste
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPlant(plantsInventory[position])


    }


    //totale elementi
    override fun getItemCount(): Int {
        return plantsInventory.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_item_row, parent, false)

        return ViewHolder(view) { onPlantSelected(it) } //plant -> onPlantSelected(plant)
    }




    inner class ViewHolder(view: View,val  onClick:(Plant)->Unit) : RecyclerView.ViewHolder(view) {


        fun bindPlant(nextPlant: Plant) {

            itemView.setOnClickListener { onClick(nextPlant) }

            val namePlant = itemView.findViewById(R.id.txtPlantName) as TextView
            namePlant.text = nextPlant.name
            val qtPlant = itemView.findViewById(R.id.txtPlantQuantity) as TextView
            qtPlant.text = nextPlant.quantity.toString()

        }
    }




}

