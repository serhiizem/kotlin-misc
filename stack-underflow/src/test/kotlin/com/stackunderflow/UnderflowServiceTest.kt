package com.stackunderflow

import com.stackunderflow.domain.Question
import com.stackunderflow.domain.User
import com.stackunderflow.repository.IQuestionRepository
import com.stackunderflow.repository.IUserRepository
import com.stackunderflow.service.UnderflowService
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

class UnderflowServiceTest {

    @Nested
    inner class WithExplicitMocks {
        val questionRepository: IQuestionRepository = mockk<IQuestionRepository>()
        val userRepository = mockk<IUserRepository>()

        val questionId = 2000
        val userId = 47
        val voterId = 23

        @Test
        fun `should be able to vote up question`() {
            val underflowService = UnderflowService(questionRepository, userRepository)
            val user = User(userId, "Kevin", 0, 0, 0, 0)
            val voter = User(voterId, "Kevin", 0, 0, 0, 20)
            val question = Question(questionId, user, "Title", "Discussion")

            every { questionRepository.findQuestion(questionId) } returns question
            every { userRepository.findUser(userId) } returns user
            every { userRepository.findUser(questionId) } returns user
            every { userRepository.findUser(voterId) } returns voter
            every { userRepository.update(user) } just Runs
            every { questionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 1

            verify {
                questionRepository.findQuestion(questionId)
            }
        }
    }

    @Nested
    inner class TestWithAnnotations {

        @MockK
        lateinit var questionRepository: IQuestionRepository

        @MockK
        lateinit var userRepository: IUserRepository

        init {
            MockKAnnotations.init(this)
        }

        val questionId = 2000
        val userId = 47
        val voterId = 23

        @Test
        fun `should be able to vote up question`() {
            val underflowService = UnderflowService(questionRepository, userRepository)
            val user = User(userId, "Kevin", 0, 0, 0, 0)
            val voter = User(voterId, "Kevin", 0, 0, 0, 20)
            val question = Question(questionId, user, "Title", "Discussion")

            every { questionRepository.findQuestion(questionId) } returns question
            every { userRepository.findUser(userId) } returns user
            every { userRepository.findUser(questionId) } returns user
            every { userRepository.findUser(voterId) } returns voter
            every { userRepository.update(user) } just Runs
            every { questionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 1

        }


    }

    @Nested
    @ExtendWith(MockKExtension::class)
    inner class TestWithExtend {

        @MockK
        lateinit var questionRepository: IQuestionRepository

        @MockK
        lateinit var userRepository: IUserRepository

        val questionId = 2000
        val userId = 47
        val voterId = 23

        @Test
        fun `should be able to vote up question`() {
            val underflowService = UnderflowService(questionRepository, userRepository)
            val user = User(userId, "Kevin", 0, 0, 0, 0)
            val voter = User(voterId, "Kevin", 0, 0, 0, 20)
            val question = Question(questionId, user, "Title", "Discussion")

            every { questionRepository.findQuestion(questionId) } returns question
            every { userRepository.findUser(userId) } returns user
            every { userRepository.findUser(questionId) } returns user
            every { userRepository.findUser(voterId) } returns voter
            every { userRepository.update(user) } just Runs
            every { questionRepository.update(question) } just Runs

            val votes = underflowService.voteUpQuestion(questionId, voterId)

            votes `should be` 1

        }

    }

}