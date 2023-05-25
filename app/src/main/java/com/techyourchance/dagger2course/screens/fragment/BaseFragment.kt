package com.techyourchance.dagger2course.screens.fragment

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.screens.activity.BaseActivity

open class BaseFragment : Fragment() {

    protected val compositionRoot
        get() = (requireActivity() as BaseActivity).compositionRoot
}