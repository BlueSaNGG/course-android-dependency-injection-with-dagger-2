package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.ActivityCompositionRoot
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot
        get() = (application as MyApplication).appCompositionRoot

    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(
            this, appCompositionRoot
        )
    }

    private val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    protected val injector by lazy {
        Injector(compositionRoot)
    }
}