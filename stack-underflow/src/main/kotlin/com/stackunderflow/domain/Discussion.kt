package com.stackunderflow.domain

import java.time.LocalDateTime

abstract class Discussion(
    val id: Int,
    val author: User,
    val flag: Boolean = false,
    val date: LocalDateTime = LocalDateTime.now()
) {

    var votes = 0
        protected set

    private val _comments = mutableListOf<Comment>()

    val comments: List<Comment>
        get() {
            return _comments
        }


    abstract fun vote(direction: VoteDirection)

    fun voteUp(): Int {
        vote(VoteDirection.Up)
        return votes
    }

    fun voteDown(): Int {
        vote(VoteDirection.Down)
        return votes
    }

}
