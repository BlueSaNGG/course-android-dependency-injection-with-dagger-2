package com.techyourchance.dagger2course.common.composition

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator

class ActivityCompositionRoot(
    val activity: AppCompatActivity, private val appCompositionRoot: AppCompositionRoot
) {


    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val fragmentManager
        get() = activity.supportFragmentManager
    
    val dialogsNavigator
        get() = DialogsNavigator(fragmentManager)

    private val stackoverflowApi
        get() = appCompositionRoot.stackoverflowApi

    val fetchQuestionsUseCase: FetchQuestionsUseCase
        get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
        get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}