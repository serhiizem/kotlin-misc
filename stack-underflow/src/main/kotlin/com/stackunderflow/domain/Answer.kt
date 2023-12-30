package com.stackunderflow.domain

class Answer(id: Int, user: User) {

    var votes: Int = 0

    fun vote(direction: VoteDirection) {
        when (direction) {
            VoteDirection.Up -> votes++
            VoteDirection.Down -> votes--
        }
    }
}