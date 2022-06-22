package com.example.quizappfragments.contract

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

fun Fragment.navigator() = requireActivity() as Navigator

interface Navigator {

    fun startQuiz()

    fun finishQuiz(rightAnswers: Int)
}