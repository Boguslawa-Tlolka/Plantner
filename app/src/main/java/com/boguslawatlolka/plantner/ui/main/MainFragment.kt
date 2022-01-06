package com.boguslawatlolka.plantner.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.boguslawatlolka.plantner.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(R.layout.fragment_main) {

    private val plantList: PlantList = PlantList()

    private val viewModel by activityViewModels<MainViewModel> {
        MainViewModelFactory(plantList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plantsAdapter = PlantsAdapter()
        plantsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = plantsAdapter
        }

        viewModel.plantsLiveData.observe(viewLifecycleOwner) {plants ->
            plantsAdapter.submitList(plants)
        }

        addButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_addPlantFragment)
        }

    }

    companion object {
            fun newInstance() = MainFragment()
    }
}