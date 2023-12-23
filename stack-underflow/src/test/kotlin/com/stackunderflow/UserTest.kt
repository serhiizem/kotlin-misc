package com.stackunderflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UserTest {

    @Nested
    inner class VoteIncreaseTest {

        @Test
        fun `reputation when question or answer is voted up`() {
            val user = User(1, "Sam", 0)

            user.questionOrAnswerVotedOn(VoteDirection.Up)

            assertEquals(1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted up and the user has an initial reputation`() {
            val user = User(1, "Sam", 10)

            user.questionOrAnswerVotedOn(VoteDirection.Up)

            assertEquals(11, user.reputation)
        }
    }

    @Nested
    inner class VoteDecreaseTest {

        @Test
        fun `reputation when question or answer is voted down`() {
            val user = User(1, "Sam", 0)

            user.questionOrAnswerVotedOn(VoteDirection.Down)

            assertEquals(-1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted down and the user has an initial reputation`() {
            val user = User(1, "Sam", 10)

            user.questionOrAnswerVotedOn(VoteDirection.Down)

            assertEquals(9, user.reputation)
        }
    }

}