package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
    }


    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder().activityComponent(activityComponent)
            .presentationModule(PresentationModule()).build()
    }

    protected val injector
        get() = presentationComponent

}