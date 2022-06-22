package com.example.quizapp

class Question (
    val question: String,
    val image: Int,
    val options: List<QuizOption>
) {
    fun getRightOptionName() = options.find { it.rightAnswer }?.name
}