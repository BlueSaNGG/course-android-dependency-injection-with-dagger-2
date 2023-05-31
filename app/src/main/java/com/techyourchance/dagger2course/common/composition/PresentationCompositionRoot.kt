package com.techyourchance.dagger2course.common.composition

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewMvc.ViewMvcFactory

class PresentationCompositionRoot(
    private val activityCompositionRoot: ActivityCompositionRoot
) {

    private val fragmentManager
        get() = activityCompositionRoot.fragmentManager

    private val layoutInflater
        get() = activityCompositionRoot.layoutInflater

    private val stackoverflowApi
        get() = activityCompositionRoot.stackoverflowApi

    val screensNavigator
        get() = activityCompositionRoot.screensNavigator

    val viewMvcFactory
        get() = ViewMvcFactory(layoutInflater)

    val dialogsNavigator
        get() = DialogsNavigator(fragmentManager)

    val fetchQuestionsUseCase: FetchQuestionsUseCase
        get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
        get() = FetchQuestionDetailsUseCase(stackoverflowApi)

}