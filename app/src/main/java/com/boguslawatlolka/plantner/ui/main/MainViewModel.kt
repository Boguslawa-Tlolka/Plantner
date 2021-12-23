package com.boguslawatlolka.plantner.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {

    private val _data = MutableLiveData<List<Plant>>()
    val data: LiveData<List<Plant>> = _data

    init {
        showData()
    }

    fun showData() {
        _data.value = List(20) { index ->
            val id = index + 1
            Plant(
                id = id,
                name = "Plant $id",
                description = "Description $id"
            )
        }
    }
}