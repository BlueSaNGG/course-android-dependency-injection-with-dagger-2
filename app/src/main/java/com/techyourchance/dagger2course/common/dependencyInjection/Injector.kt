package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(fragment: QuestionListFragment) {
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }

}