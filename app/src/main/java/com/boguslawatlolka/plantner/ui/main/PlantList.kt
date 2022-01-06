package com.boguslawatlolka.plantner.ui.main

import androidx.lifecycle.MutableLiveData

class PlantList {

    private val initialPlantList = mutableListOf<Plant>()
    private val plantsLiveData = MutableLiveData<List<Plant>>()

    fun addPlant(plant: Plant) {
        initialPlantList.add(plant)
        plantsLiveData.value = initialPlantList
    }

    fun getPlantList(): MutableLiveData<List<Plant>> {
        return plantsLiveData
    }

}