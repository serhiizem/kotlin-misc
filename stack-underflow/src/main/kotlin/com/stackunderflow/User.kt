package com.stackunderflow

class User(val id: Int, val name: String, var reputation: Int) {

    init {
        if (id <= 0) throw IllegalArgumentException()
        if (name.trim().isEmpty()) throw IllegalArgumentException()
    }

    fun questionOrAnswerVotedOn(direction: VoteDirection) {
        when (direction) {
            VoteDirection.Up -> reputation++
            VoteDirection.Down -> reputation--
        }
    }
}

