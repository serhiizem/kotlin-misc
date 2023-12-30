package com.stackunderflow

import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class AnswerTest {

    private val user = User(1, "Sam", 0)

    @Test
    fun shouldIncreaseVoteWhenVotedUp() {
        val answer = Answer(1, user)

        answer.vote(VoteDirection.Up)

        answer.votes.shouldBeEqualTo(1)
    }

    @Test
    fun shouldDecreaseVoteWhenVotedDone() {
        val answer = Answer(1, user)

        answer.vote(VoteDirection.Down)

        answer.votes `should be equal to` (-1)
    }
}