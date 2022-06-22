package com.example.quizappfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import com.example.quizappfragments.contract.navigator
import com.example.quizappfragments.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    var rightAnswers: Int? = null
    lateinit var binding: FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentResultsBinding.inflate(inflater, container, false)


        with(binding) {
            startAgainBtn.setOnClickListener { navigator().startQuiz() }
            val rightAnswers = arguments?.getInt("rightAnswers").toString()
            resultsTV.text = getString(R.string.congratulations_with_result, rightAnswers)
        }

        return binding.root
    }

    companion object {
        fun newInstance(result: Int): ResultsFragment {
            val args = bundleOf("rightAnswers" to result)
            val fragment = ResultsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}