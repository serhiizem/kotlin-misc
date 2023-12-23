package com.stackunderflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnswerTest {

    private val user = User(1, "Sam", 0)

    @Test
    fun shouldIncreaseVoteWhenVotedUp() {
        val answer = Answer(1, user)

        answer.vote(VoteDirection.Up)

        assertEquals(1, answer.votes)
    }

    @Test
    fun shouldDecreaseVoteWhenVotedDone() {
        val answer = Answer(1, user)

        answer.vote(VoteDirection.Down)

        assertEquals(-1, answer.votes)

    }
}