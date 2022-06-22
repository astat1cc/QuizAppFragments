package com.example.quizappfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.quizappfragments.contract.Navigator
import com.example.quizappfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigator {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragmentContainer, FirstLoadingFragment())
                .commit()
        }
    }

    override fun startQuiz() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, QuestionsFragment())
            .commit()
    }

    override fun finishQuiz(rightAnswers: Int) {
        with(supportFragmentManager) {
            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            beginTransaction()
                .replace(R.id.fragmentContainer, ResultsFragment.newInstance(rightAnswers))
                .commit()
        }
    }
}