package com.niki.herbarium.presentation.presenter

import com.niki.herbarium.data.Plant
import com.niki.herbarium.presentation.MVP
import com.niki.herbarium.presentation.view.InventoryScreen
import io.realm.Realm
import io.realm.RealmResults

/**
 * Created by Admin on 2/23/2017.
 *
 */
class InventoryPresenter : MVP.Presenter<InventoryScreen>() {

    fun viewIsReady() {
        view?.loadPlants(getPlants())
    }


    fun getPlants(): List<Plant> {
        val realm: Realm = Realm.getDefaultInstance()
        val result : RealmResults<Plant>? = realm.where(Plant::class.java).findAll()

        return result as List<Plant>
    }

}

/*
// Build the query looking at all users:
RealmQuery<User> query = realm.where(User.class);

// Add query conditions:
query.equalTo("name", "John");
query.or().equalTo("name", "Peter");

// Execute the query:
RealmResults<User> result1 = query.findAll();

// Or alternatively do the same all at once (the "Fluent interface"):
RealmResults<User> result2 = realm.where(User.class)
.equalTo("name", "John")
.or()
.equalTo("name", "Peter")
.findAll();*/