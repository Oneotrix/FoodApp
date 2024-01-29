package com.dipom.food.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.dipom.food.databinding.FragmentMealsBinding
import com.dipom.food.mvp.ui.adapter.MealsAdapter

class MealsFragment: Fragment() {

    private var _binding: FragmentMealsBinding? = null
    private val binding: FragmentMealsBinding
        get() = _binding!!

    private val mealsAdapter by lazy {
        MealsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealsBinding.inflate(inflater, container, false)
        binding.rvMeals.adapter = mealsAdapter
        //TODO mealsAdapter.submitList()
        return binding.root
    }

    companion object {
        fun newInstance() = MealsFragment()
    }
}