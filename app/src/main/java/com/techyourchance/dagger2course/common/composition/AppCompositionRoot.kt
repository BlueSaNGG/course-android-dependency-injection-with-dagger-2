package com.techyourchance.dagger2course.common.composition

import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppCompositionRoot {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val stackoverflowApi: StackoverflowApi by lazy {
        retrofit.create(
            StackoverflowApi::class.java
        )
    }

}