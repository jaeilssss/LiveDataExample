package com.example.mvvmproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var listItem = MutableLiveData<String>()
    var test = MutableLiveData<ArrayList<String>>()

    var i = 1
    fun create (){
        listItem.value = (i++).toString()
    }
}