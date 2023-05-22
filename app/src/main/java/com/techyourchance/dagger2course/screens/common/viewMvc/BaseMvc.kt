package com.techyourchance.dagger2course.screens.common.viewMvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

open class BaseMvc<LISTENER_TYPE>(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?,
    @LayoutRes val layoutId: Int
) {
    protected val listeners = hashSetOf<LISTENER_TYPE>()

    val rootView: View = layoutInflater.inflate(layoutId, parent, false)
    protected val context: Context
        get() = rootView.context

    fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }


    protected fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }


}