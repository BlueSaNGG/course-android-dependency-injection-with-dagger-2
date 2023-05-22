package com.techyourchance.dagger2course.screens.questiondetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewMvc.BaseMvc

class QuestionDetailsMvc(
    layoutInflater: LayoutInflater, parent: ViewGroup?
) : BaseMvc<QuestionDetailsMvc.Listener>(
    layoutInflater, parent, R.layout.layout_question_details
) {

    interface Listener {
        fun onBackClicked()
    }

    private var toolbar: MyToolbar = findViewById(R.id.toolbar)
    private var swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipeRefresh)
    var txtQuestionBody: TextView = findViewById(R.id.txt_question_body)


    init {

        // init toolbar
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onBackClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh.isEnabled = false
    }


    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }


}

