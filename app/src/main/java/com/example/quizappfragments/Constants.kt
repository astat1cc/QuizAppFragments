package com.example.quizapp

import com.example.quizappfragments.R

object Constants {

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val options1 = listOf(
            QuizOption("USA", true),
            QuizOption("Russia", false),
            QuizOption("Germany", false),
            QuizOption("France", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.usa_flag,
                options1
            )
        )

        val options2 = listOf(
            QuizOption("Slovakia", false),
            QuizOption("France", false),
            QuizOption("Switzerland", true),
            QuizOption("Russia", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.switzerland_flag,
                options2
            )
        )

        val options3 = listOf(
            QuizOption("Russia", false),
            QuizOption("Czech", true),
            QuizOption("Netherlands", false),
            QuizOption("France", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.czech_flag,
                options3
            )
        )

        val options4 = listOf(
            QuizOption("India", true),
            QuizOption("Russia", false),
            QuizOption("USA", false),
            QuizOption("France", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.india_flag,
                options4
            )
        )

        val options5 = listOf(
            QuizOption("Switzerland", false),
            QuizOption("Russia", false),
            QuizOption("Germany", true),
            QuizOption("Czech", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.gernamy_flag,
                options5
            )
        )

        val options6 = listOf(
            QuizOption("Netherlands", true),
            QuizOption("India", false),
            QuizOption("Germany", false),
            QuizOption("Russia", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.netherlands_flag,
                options6
            )
        )

        val options7 = listOf(
            QuizOption("USA", false),
            QuizOption("Russia", false),
            QuizOption("France", true),
            QuizOption("India", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.france_flag,
                options7
            )
        )

        val options8 = listOf(
            QuizOption("USA", false),
            QuizOption("Slovakia", true),
            QuizOption("Czech", false),
            QuizOption("Netherlands", false)
        )
        questions.add(
            Question(
                "What country does this flag belong to?",
                R.drawable.slovakia_flag,
                options8
            )
        )

        return questions
    }

}