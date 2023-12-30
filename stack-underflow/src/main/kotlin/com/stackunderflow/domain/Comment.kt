package com.stackunderflow.domain

import com.stackunderflow.exceptions.MalformedQuestionException
import java.time.LocalDateTime

class Comment(
    id: Int,
    val body: CommentBody,
    author: User,
    flag: Boolean,
    created: LocalDateTime = LocalDateTime.now()
) : Discussion(id, author, flag, created) {

    override fun vote(direction: VoteDirection) {

        when (direction) {
            VoteDirection.Up -> votes++
            VoteDirection.Down -> {}
        }
    }

}

@JvmInline
value class CommentBody(private val comment: String) {
    init {
        if (comment.trim().isEmpty()) throw MalformedQuestionException("Comment is empty")
        if (comment.length > 255) throw MalformedQuestionException("Comment is too long")
    }
}