package com.stackunderflow

import com.stackunderflow.exceptions.MalformedQuestionException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class QuestionTest {

    @Nested
    inner class PreconditionsTest {

        @Test
        fun `should have a valid title`() {
            val user = User(1, "Sam", 0)

            assertThrows(MalformedQuestionException::class.java) { Question(1, user, "", "ggg") }
        }

        @Test
        fun `should have a valid discussion`() {
            val user = User(1, "Sam", 0)


            assertThrows(MalformedQuestionException::class.java) { Question(1, user, "fff", "") }
        }
    }

}