package com.stackunderflow

import com.stackunderflow.exceptions.MalformedQuestionException

class Question(val id: Int, user: User, title: String, discussion: String) {

    init {
        if (title.trim().isEmpty()) throw MalformedQuestionException()
        if (discussion.trim().isEmpty()) throw MalformedQuestionException()
    }

    private val _answers = mutableListOf<Answer>()

    val answers: List<Answer>
        get() {
            return _answers.toList()
        }

    fun addAnswer(answer: Answer) {
        _answers.add(answer)
    }
}