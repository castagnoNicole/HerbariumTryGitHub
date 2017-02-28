package com.niki.herbarium

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.niki.herbarium.data.Plant
import com.niki.herbarium.presentation.view.InventoryController
import io.realm.Realm

class Inventory : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        val realm : Realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.deleteAll()
        }
        realm.executeTransaction {

            for (i in 0..100){
                val genericPlant = realm.createObject(Plant::class.java, "PlantName no. $i")

                genericPlant.quantity = i
            }
        }

        val container = findViewById(R.id.layoutRoot) as ViewGroup

        val router: Router = Conductor.attachRouter(this, container, savedInstanceState)


        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(InventoryController()));
        }



    }


}


