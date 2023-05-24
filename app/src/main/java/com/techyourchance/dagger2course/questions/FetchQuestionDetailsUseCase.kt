package com.techyourchance.dagger2course.questions

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchQuestionDetailsUseCase(private val stackoverflowApi: StackoverflowApi) {

    sealed class Result {
        class Success(val questionBody: Spanned) : Result()
        object Failure : Result()
    }

    suspend fun fetchQuestionDetails(questionId: String): FetchQuestionDetailsUseCase.Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    val questionBody = response.body()!!.question.body
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        return@withContext FetchQuestionDetailsUseCase.Result.Success(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY))
                    } else {
                        @Suppress("DEPRECATION")
                        return@withContext FetchQuestionDetailsUseCase.Result.Success(questionBody = Html.fromHtml(questionBody))
                    }
                } else {
                    return@withContext FetchQuestionDetailsUseCase.Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext FetchQuestionDetailsUseCase.Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}