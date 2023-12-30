package com.stackunderflow.domain

import com.stackunderflow.exceptions.MalformedQuestionException

class Question(id: Int, user: User, title: String, discussion: String) : Discussion(id, user) {

    init {
        if (title.trim().isEmpty()) throw MalformedQuestionException("Title cannot be an empty string")
        if (discussion.trim().isEmpty()) throw MalformedQuestionException("Discussion cannot be an empty string")
    }

    private val _answers = mutableListOf<Answer>()

    val answers: List<Answer>
        get() {
            return _answers.toList()
        }

    fun addAnswer(answer: Answer) {
        _answers.add(answer)
    }

    override fun vote(direction: VoteDirection) {
        when (direction) {
            VoteDirection.Up -> votes++
            VoteDirection.Down -> votes--
        }
        author.questionOrAnswerVotedOn(direction)
    }

}