package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyInjection.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    val applicationComponent
        get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().appComponent(applicationComponent)
            .activityModule(ActivityModule(this)).build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector
        get() = presentationComponent

}