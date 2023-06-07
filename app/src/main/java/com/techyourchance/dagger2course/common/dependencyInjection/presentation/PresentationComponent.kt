package com.techyourchance.dagger2course.common.dependencyInjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {

    fun inject(fragment: QuestionListFragment)
    fun inject(activity: QuestionDetailsActivity)

}