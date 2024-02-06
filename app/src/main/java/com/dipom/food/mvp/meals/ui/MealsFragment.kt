package com.dipom.food.mvp.meals.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dipom.food.App
import com.dipom.food.databinding.FragmentMealsBinding
import com.dipom.food.mvp.meals.MealItemModel
import com.dipom.food.mvp.meals.MealsContract
import com.dipom.food.mvp.meals.MealsPresenter
import com.dipom.food.mvp.meals.ui.recycler.MealsAdapter
import javax.inject.Inject

class MealsFragment: Fragment(), MealsContract.View {

    private var _binding: FragmentMealsBinding? = null
    private val binding: FragmentMealsBinding
        get() = _binding!!

    private val mealsAdapter by lazy {
        MealsAdapter(App.appComponent.providePicasso())
    }

    @Inject
    lateinit var presenter: MealsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.mealsFragmentBuilder()
            .view(this@MealsFragment)
            .build()
            .inject(this@MealsFragment)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealsBinding.inflate(inflater, container, false)

        binding.rvMeals.adapter = mealsAdapter

        presenter.mealsRequest()

        return binding.root
    }
    override fun populateMeals(list: List<MealItemModel>) {
        mealsAdapter.submitList(list)
    }

    companion object {
        fun newInstance() = MealsFragment()

    }
}