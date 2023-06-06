package com.techyourchance.dagger2course.common.dependencyInjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.dependencyInjection.application.AppComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun application(): AppCompatActivity

    fun activity(): AppCompatActivity

    fun fragmentManager(): FragmentManager

    fun layoutInflater(): LayoutInflater

    fun stackoverflowApi(): StackoverflowApi

    fun screensNavigator(): ScreensNavigator


}