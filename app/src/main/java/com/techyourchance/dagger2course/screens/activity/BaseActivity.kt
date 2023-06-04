package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyInjection.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot
        get() = (application as MyApplication).appCompositionRoot

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, appCompositionRoot))
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector
        get() = Injector(presentationComponent)

}