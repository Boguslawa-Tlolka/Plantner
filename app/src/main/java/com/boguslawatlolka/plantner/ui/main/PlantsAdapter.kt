package com.boguslawatlolka.plantner.ui.main

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.boguslawatlolka.plantner.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.plant.*

class PlantsAdapter: ListAdapter<Plant, PlantViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val plantView = LayoutInflater.from(parent.context)
            .inflate(R.layout.plant, parent, false)
        return PlantViewHolder(plantView)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback: DiffUtil.ItemCallback<Plant>(){
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }

    }
}

class PlantViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
    fun bind(plant: Plant) {
        plantName.text = plant.name
        plantDescription.text = plant.description
    }

}