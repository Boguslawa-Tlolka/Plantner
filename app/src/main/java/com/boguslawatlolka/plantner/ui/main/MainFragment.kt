package com.boguslawatlolka.plantner.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.boguslawatlolka.plantner.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plantsAdapter = PlantsAdapter()
        plantsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = plantsAdapter
        }

        viewModel.data.observe(viewLifecycleOwner) {plants ->
            plantsAdapter.submitList(plants)
        }
    }

        companion object {
            fun newInstance() = MainFragment()
        }

}