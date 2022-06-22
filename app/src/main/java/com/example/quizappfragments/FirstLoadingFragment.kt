package com.example.quizappfragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizappfragments.contract.navigator

class FirstLoadingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val handler = Handler(Looper.getMainLooper())
        val startQuiz = Runnable { navigator().startQuiz() }
        handler.postDelayed(
            startQuiz,
            2000
        )

        return inflater.inflate(R.layout.fragment_first_loading, container, false)
    }
}