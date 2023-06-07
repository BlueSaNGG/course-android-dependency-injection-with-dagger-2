package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private val applicationComponent
        get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        applicationComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector
        get() = presentationComponent

}