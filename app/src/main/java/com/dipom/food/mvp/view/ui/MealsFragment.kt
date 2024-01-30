package com.dipom.food.mvp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dipom.food.databinding.FragmentMealsBinding
import com.dipom.food.di.DaggerAppComponent
import com.dipom.food.di.modules.ContextModule
import com.dipom.food.mvp.model.MealItemModel
import com.dipom.food.mvp.presenter.MealsPresenter
import com.dipom.food.mvp.view.MealsContract
import com.dipom.food.mvp.view.ui.recycler.MealsAdapter
import com.dipom.food.network.api.MealsApi
import com.squareup.picasso.Picasso

class MealsFragment: Fragment(), MealsContract.View {

    private var _binding: FragmentMealsBinding? = null
    private val binding: FragmentMealsBinding
        get() = _binding!!


    private lateinit var picasso: Picasso
    private lateinit var mealsService: MealsApi

    private val mealsAdapter by lazy {
        MealsAdapter(picasso)
    }

    private val presenter by lazy {
        MealsPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealsBinding.inflate(inflater, container, false)
        val daggerAppComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(requireContext()))
            .build()

        mealsService  = daggerAppComponent.getMealsService()
        picasso = daggerAppComponent.getPicasso()

        binding.rvMeals.adapter = mealsAdapter

        presenter.mealsRequest(mealsService)

        return binding.root
    }

    override fun populateMeals(list: List<MealItemModel>) {
        mealsAdapter.submitList(list)
    }

    companion object {
        fun newInstance() = MealsFragment()
    }


}