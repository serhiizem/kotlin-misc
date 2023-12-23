package com.stackunderflow

import com.stackunderflow.exceptions.MalformedQuestionException

class Question(val id: Int, user: User, title: String, discussion: String) {

    init {
        if (title.trim().isEmpty()) throw MalformedQuestionException()
        if (discussion.trim().isEmpty()) throw MalformedQuestionException()
    }
}