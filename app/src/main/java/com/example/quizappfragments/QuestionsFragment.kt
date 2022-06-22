package com.example.quizappfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.quizapp.Constants
import com.example.quizapp.Question
import com.example.quizappfragments.contract.navigator
import com.example.quizappfragments.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {

    lateinit var binding: FragmentQuestionsBinding
    lateinit var optionsTV: List<TextView>
    var currentQuestionID = 0
    val questions = Constants.getQuestions()
    val totalNumOfQuestions = questions.count()
    var optionsClickable = false
    var selectedOption: TextView? = null
    var rightAnswers = 0
    var isLastQuestion = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionsBinding.inflate(inflater, container, false)

        optionsTV = with(binding) {
            listOf(option1TV, option2TV, option3TV, option4TV)
        }

        setViewsWithQuestion(questions[currentQuestionID])

        with(binding) {
            option1TV.setOnClickListener { chooseOption(it) }
            option2TV.setOnClickListener { chooseOption(it) }
            option3TV.setOnClickListener { chooseOption(it) }
            option4TV.setOnClickListener { chooseOption(it) }
            nextQuestionBTN.setOnClickListener { showNextQuestion() }
        }

        return binding.root
    }

    private fun showNextQuestion() {
        if (!isLastQuestion) {
            currentQuestionID++
            resetSelectedOption()
            binding.nextQuestionBTN.visibility = View.INVISIBLE
            setViewsWithQuestion(questions[currentQuestionID])
        } else {
            navigator().finishQuiz(rightAnswers)
        }
    }

    private fun resetSelectedOption() {
        selectedOption?.setBackgroundResource(R.drawable.option_background)
    }

    private fun setViewsWithQuestion(question: Question) {
        binding.flagIV.setImageResource(question.image)
        binding.questionTV.text = question.question
        for ((i, option) in optionsTV.withIndex()) {
            option.text = question.options[i].name
        }
        with(binding) {
            progressBar.progress = currentQuestionID
            progressTV.text = "$currentQuestionID/$totalNumOfQuestions"
        }
        optionsClickable = true
    }

    private fun chooseOption(view: View?) {
        if (view is TextView) {
            if (optionsClickable) {
                if (view.text == questions[currentQuestionID].getRightOptionName()) {
                    view.setBackgroundResource(R.drawable.right_option_background)
                    rightAnswers++
                } else {
                    view.setBackgroundResource(R.drawable.wrong_option_background)
                    Log.d("checking", "click")
                }
                optionsClickable = false
                if (currentQuestionID == totalNumOfQuestions - 1) {
                    binding.nextQuestionBTN.text = "finish"
                    isLastQuestion = true
                }
                binding.nextQuestionBTN.visibility = View.VISIBLE
                selectedOption = view
            }
        }
    }
}