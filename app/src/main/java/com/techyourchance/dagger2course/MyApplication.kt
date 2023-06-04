package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyInjection.application.AppComponent
import com.techyourchance.dagger2course.common.dependencyInjection.application.AppModule
import com.techyourchance.dagger2course.common.dependencyInjection.application.DaggerAppComponent

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}