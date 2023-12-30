package com.stackunderflow.repository

import com.stackunderflow.domain.Question
import com.stackunderflow.domain.User

interface IQuestionRepository {
    fun add(question: Question)
    fun update(question: Question)
    fun findQuestion(questionId: Int): Question
}

interface IUserRepository {
    fun findUser(voterId: Int): User
    fun update(user: User)

}

class QuestionRepository : IQuestionRepository {
    override fun findQuestion(questionId: Int): Question {
        TODO("not implemented")
    }

    override fun update(question: Question) {
        TODO("not implemented")
    }

    override fun add(question: Question) {
        TODO("not implemented")
    }
}