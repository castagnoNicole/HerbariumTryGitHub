package com.niki.herbarium.presentation

/**
 * Created by Admin on 2/23/2017.
 */
interface MVP {
    interface View
    abstract class Presenter<V : View> {
        var view: V? = null
    }
}
