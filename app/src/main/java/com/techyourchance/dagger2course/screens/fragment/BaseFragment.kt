package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.Injector
import com.techyourchance.dagger2course.common.dependencyInjection.PresentationCompositionRoot
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityCompositionRoot
        get() = (requireActivity() as BaseActivity).activityCompositionRoot

    private val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    protected val injector by lazy {
        Injector(compositionRoot)
    }

}