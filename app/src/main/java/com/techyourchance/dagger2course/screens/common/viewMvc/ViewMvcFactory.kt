package com.techyourchance.dagger2course.screens.common.viewMvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater, private val imageLoader: ImageLoader
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListMvc {
        return QuestionsListMvc(layoutInflater, parent)
    }

    fun newQuestionDetailViewMvc(parent: ViewGroup?): QuestionDetailsMvc {
        return QuestionDetailsMvc(layoutInflater, imageLoader, parent)
    }

}