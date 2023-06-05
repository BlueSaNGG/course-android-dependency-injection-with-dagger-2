package com.techyourchance.dagger2course.common.dependencyInjection.application

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(
    private val application: Application
) {

    @AppScope
    @Provides
    fun retrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @AppScope
    @Provides
    fun stackoverflowApi(retrofit: Retrofit): StackoverflowApi {
        return retrofit.create(
            StackoverflowApi::class.java
        )
    }

    @Provides
    fun application() = application

}