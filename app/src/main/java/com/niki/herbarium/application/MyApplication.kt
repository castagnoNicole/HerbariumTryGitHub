package com.niki.herbarium.application

import android.app.Application
import io.realm.Realm
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import io.realm.RealmConfiguration.Builder


/**
 * Created by Admin on 2/23/2017.
 */
open class MyApplication : Application(){


    override  fun  onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

    }

}