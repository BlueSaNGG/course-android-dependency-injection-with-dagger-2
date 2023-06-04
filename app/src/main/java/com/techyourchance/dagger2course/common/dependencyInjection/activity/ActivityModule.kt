package com.techyourchance.dagger2course.common.dependencyInjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyInjection.AppCompositionRoot
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity, private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    @Provides
    fun application() = appCompositionRoot.application

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides
    fun layoutInflater() = activity.layoutInflater

    @Provides
    fun stackoverflowApi() = appCompositionRoot.stackoverflowApi

    @Provides
    fun screensNavigator(activity: AppCompatActivity) = screensNavigator

    @Provides
    fun activity() = activity
}