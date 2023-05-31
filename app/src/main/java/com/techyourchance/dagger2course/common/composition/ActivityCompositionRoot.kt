package com.techyourchance.dagger2course.common.composition

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    val activity: AppCompatActivity, private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager
        get() = activity.supportFragmentManager

    val layoutInflater
        get() = activity.layoutInflater

    val stackoverflowApi
        get() = appCompositionRoot.stackoverflowApi

}