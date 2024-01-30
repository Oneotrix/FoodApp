package com.dipom.food.mvp.ui

import android.app.AppComponentFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dipom.food.databinding.FragmentMealsBinding
import com.dipom.food.di.AppComponent
import com.dipom.food.di.DaggerAppComponent
import com.dipom.food.di.modules.ContextModule
import com.dipom.food.mvp.model.MealItemModel
import com.dipom.food.mvp.ui.recycler.MealsAdapter
import com.dipom.food.network.api.MealsApi
import com.dipom.food.network.model.RecipeNetModel
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class MealsFragment: Fragment() {

    private var _binding: FragmentMealsBinding? = null
    private val binding: FragmentMealsBinding
        get() = _binding!!

    private lateinit var picasso: Picasso

    private lateinit var mealsService: MealsApi

    private val mealsAdapter by lazy {
        MealsAdapter(picasso)
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

        retrofitRequest()

        return binding.root
    }


    fun retrofitRequest() {

        val call: Call<RecipeNetModel> = mealsService.getRecipes()
        call.enqueue(object : Callback<RecipeNetModel> {
            override fun onResponse(
                call: Call<RecipeNetModel>,
                response: Response<RecipeNetModel>
            ) {
                val list = mutableListOf<MealItemModel>()
                response.body()?.hits?.forEach {
                    list.add(
                        MealItemModel(
                            img = it.recipe?.image,
                            name = it.recipe?.label,
                    )
                    )
                }

                mealsAdapter.submitList(list)
            }

            override fun onFailure(call: Call<RecipeNetModel>, t: Throwable) {
                Timber.e(t)
            }

        })

    }

    companion object {
        fun newInstance() = MealsFragment()
    }
}