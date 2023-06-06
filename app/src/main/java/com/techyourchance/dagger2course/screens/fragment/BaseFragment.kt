package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
    }


    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule())
    }

    protected val injector
        get() = presentationComponent

}