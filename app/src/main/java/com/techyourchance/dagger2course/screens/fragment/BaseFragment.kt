package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.PresentationModule
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityCompositionRoot
        get() = (requireActivity() as BaseActivity).activityCompositionRoot


    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityCompositionRoot))
            .build()
    }

    protected val injector
        get() = Injector(presentationComponent)

}