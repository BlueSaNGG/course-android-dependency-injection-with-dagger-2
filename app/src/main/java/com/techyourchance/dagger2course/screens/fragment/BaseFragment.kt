package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.composition.PresentationCompositionRoot
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    private val activityCompositionRoot
        get() = (requireActivity() as BaseActivity).activityCompositionRoot

    protected val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

}