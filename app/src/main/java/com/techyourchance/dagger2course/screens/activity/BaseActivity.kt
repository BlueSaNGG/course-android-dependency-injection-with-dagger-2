package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyInjection.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {


    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, (application as MyApplication).appComponent))
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent)).build()
    }

    protected val injector
        get() = presentationComponent

}