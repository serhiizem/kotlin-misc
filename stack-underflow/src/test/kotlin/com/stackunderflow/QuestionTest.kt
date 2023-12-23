package com.stackunderflow

import com.stackunderflow.exceptions.MalformedQuestionException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
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
            val user = User(1, "Sam", 0)

            assertThrows(MalformedQuestionException::class.java) { Question(1, user, "", "ggg") }
        }

        @EmptySource
        @ParameterizedTest
        fun `should have a valid discussion`(discussion: String) {
            val user = User(1, "Sam", 0)

            assertThrows(MalformedQuestionException::class.java) { Question(1, user, "fff", discussion) }
        }
    }

}