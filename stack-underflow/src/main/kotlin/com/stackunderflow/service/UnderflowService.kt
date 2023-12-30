package com.stackunderflow.service

import com.stackunderflow.domain.Question
import com.stackunderflow.domain.User
import com.stackunderflow.domain.VoteDirection
import com.stackunderflow.exceptions.MalformedQuestionException
import com.stackunderflow.exceptions.ServiceException
import com.stackunderflow.repository.IQuestionRepository
import com.stackunderflow.repository.IUserRepository

interface IUnderflowService {
    fun addQuestion(userId: Int, questionId: Int)
    fun addAnswer(userId: Int, answerId: Int)
    fun voteUpQuestion(questionId: Int, voterId: Int): Int
    fun voteDownQuestion(questionId: Int, voterId: Int): Int
}

interface IUserService {
    fun createUser(): User
    fun addBadge(userId: Int, badgeId: Int): Unit
}

class UnderflowService(val questionRepository: IQuestionRepository, val userRepository: IUserRepository) :
    IUnderflowService {

    override fun addAnswer(userId: Int, answerId: Int) {
        TODO("not implemented")
    }

    override fun addQuestion(userId: Int, questionId: Int) {
        TODO("not implemented")
    }

    override fun voteUpQuestion(questionId: Int, voterId: Int): Int {
        try {
            val question: Question = questionRepository.findQuestion(questionId)
            val voter: User = userRepository.findUser(voterId)
            val owner: User = userRepository.findUser(question.author.id)

            if (voter.canVote()) {
                question.voteUp()
                owner.questionOrAnswerVotedOn(VoteDirection.Up)
            } else throw MalformedQuestionException("User does not have enough reputation to vote")
            questionRepository.update(question)
            userRepository.update(owner)
            return question.votes
        } catch (ex: Exception) {
            throw ServiceException("Unable to vote up question", ex)
        }
    }

    override fun voteDownQuestion(questionId: Int, voterId: Int): Int {
        val question: Question = questionRepository.findQuestion(questionId)
        val voter: User = userRepository.findUser(voterId)
        val owner: User = userRepository.findUser(question.author.id)

        if (voter.canVote()) {
            question.voteDown()
            owner.questionOrAnswerVotedOn(VoteDirection.Down)
        } else throw MalformedQuestionException("User does not have enough reputation to vote")
        questionRepository.update(question)
        userRepository.update(owner)
        return question.votes
    }
}

class UserService(val userRepository: IUserRepository) : IUserService {
    override fun addBadge(userId: Int, badgeId: Int) {
        TODO("not implemented")
    }

    override fun createUser(): User {
        TODO("not implemented")
    }
}