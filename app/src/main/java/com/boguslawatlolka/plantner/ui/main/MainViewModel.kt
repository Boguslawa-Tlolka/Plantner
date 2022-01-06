package com.boguslawatlolka.plantner.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private val plantList: PlantList): ViewModel() {

    val plantsLiveData: MutableLiveData<List<Plant>> = plantList.getPlantList()
    var plantId = 0

    fun insertPlant(plantName: String?, plantDescription: String?) {
        if (plantName == null || plantName == "") {
            return
        }
        else {
            val newPlant = Plant(plantId, plantName, plantDescription)
            plantList.addPlant(newPlant)
            plantId += 1
        }
    }
}

class MainViewModelFactory(private val plantList: PlantList) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                plantList
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}