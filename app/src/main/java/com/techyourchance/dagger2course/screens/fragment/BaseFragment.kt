package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
    }


    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector
        get() = Injector(presentationComponent)

}