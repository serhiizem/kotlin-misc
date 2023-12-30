package com.stackunderflow.domain

const val canEditPostReputationLimit = 2000
const val canCommentReputationLimit = 50
const val canVoteReputationLimit = 15

class User(
    val id: Int,
    val name: String,
    private var goldBadges: Int,
    private var silverBadges: Int,
    private var bronzeBadges: Int,
    internal var reputation: Int
) {

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

    fun canEditPost(): Boolean {
        return reputation > canEditPostReputationLimit
    }

    fun canComment(): Boolean {
        return reputation > canCommentReputationLimit
    }

    fun canVote(): Boolean {
        return reputation > canVoteReputationLimit
    }
}

