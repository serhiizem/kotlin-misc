package com.stackunderflow

import com.stackunderflow.domain.Answer
import com.stackunderflow.domain.Question
import com.stackunderflow.domain.User
import com.stackunderflow.exceptions.MalformedQuestionException
import org.amshove.kluent.*
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class QuestionTest {

    @Nested
    inner class PreconditionsTest {

        @EmptySource
        @ValueSource(strings = [" ", "   ", "\n", "\t"])
        @ParameterizedTest
        fun `should have a valid title`(title: String) {
            val user = User(1, "Sam", 0, 0, 0, 0)

            assertThrows(MalformedQuestionException::class.java) { Question(1, user, "", "ggg") }
        }

        @EmptySource
        @ParameterizedTest
        fun `should have a valid discussion`(discussion: String) {
            val user = User(1, "Sam", 0, 0, 0, 0)

            invoking {
                Question(
                    1,
                    user,
                    "fff",
                    discussion
                )
            } shouldThrow MalformedQuestionException::class withMessage "Internal Server Error"
        }
    }

    @Nested
    inner class QuestionAnswersTest {

        @Test
        fun `should be empty when no answers yet`() {
            val user = User(1, "Sam", 0, 0, 0, 0)
            val question = Question(1, user, "title", "discussion")

            question.answers.shouldBeEmpty()
        }

        @Test
        fun `should not be empty once the first answer is added`() {
            val author = User(1, "Sam", 0, 0, 0, 0)
            val question = Question(1, author, "title", "discussion")
            val answer = Answer(1, User(2, "Alice", 20, 0, 0, 0))

            question.addAnswer(answer)

            question.answers.shouldNotBeEmpty()
        }


        @Test
        fun `should contain added answer`() {
            val author = User(1, "Sam", 0, 0, 0, 0)
            val question = Question(1, author, "title", "discussion")

            val replier = User(2, "Alice", 20, 0, 0, 0)
            val answer = Answer(1, replier)

            question.addAnswer(answer)

            question.answers.shouldContain(answer)
        }
    }

}