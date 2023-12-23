package com.stackunderflow

class User(val id: Int, val name: String, var reputation: Int) {

    fun questionOrAnswerVotedOn(direction: VoteDirection) {
        when (direction) {
            VoteDirection.Up -> reputation++
            VoteDirection.Down -> reputation--
        }
    }
}

