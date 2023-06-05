package com.techyourchance.dagger2course.common.dependencyInjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyInjection.application.AppComponent
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity, private val appComponent: AppComponent
) {


    @Provides
    fun application() = appComponent.application()

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun layoutInflater() = activity.layoutInflater

    @ActivityScope
    @Provides
    fun screensNavigator(activity: AppCompatActivity): ScreensNavigator {
        return ScreensNavigator(activity)
    }

    @Provides
    fun activity() = activity
}