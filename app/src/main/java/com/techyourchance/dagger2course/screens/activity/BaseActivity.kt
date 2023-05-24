package com.techyourchance.dagger2course.screens.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication

open class BaseActivity : AppCompatActivity() {
    val appCompositionRoot
        get() = (application as MyApplication).appCompositionRoot
}