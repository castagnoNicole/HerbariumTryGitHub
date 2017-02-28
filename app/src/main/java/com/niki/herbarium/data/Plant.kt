package com.niki.herbarium.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


/**
 * Created by Admin on 2/21/2017.
 */
open class Plant(@PrimaryKey var name: String = "", var quantity: Int = 0) : RealmObject()