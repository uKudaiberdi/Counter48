package com.example.counter48.presenter

import com.example.counter48.model.CounterModel
import com.example.counter48.view.CounterView

class Presenter {

    private val model = CounterModel()
    lateinit var view:CounterView

    fun increment(){
        model.increment()
        view.updateCount(model.count)
        if (model.getCount() == 10){
            view.showToast()
        }else if(model.getCount() == 15){
            view.getColor()
        }
    }

    fun attachView(view: CounterView){
        this.view = view
    }
}