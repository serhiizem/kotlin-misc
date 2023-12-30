package com.stackunderflow

import com.stackunderflow.domain.User
import com.stackunderflow.domain.VoteDirection
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class UserArgumentProvider : ArgumentsProvider {
    override fun provideArguments(extensionContext: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(0, "Sam"),
            Arguments.of(-1, "Sam"),
            Arguments.of(1, ""),
            Arguments.of(1, " "),
            Arguments.of(1, "\t"),
            Arguments.of(1, "\n"),
        )
    }
}

class UserTest {

    @Nested
    inner class VoteIncreaseTest {

        @ParameterizedTest(name = "Id: {0}, Name: {1}")
        @ArgumentsSource(UserArgumentProvider::class)
        fun `should be valid`(id: Int, name: String) {
            Assertions.assertThrows(IllegalArgumentException::class.java) { User(id, name, 0, 0, 0, 0) }
        }

        @Test
        fun `reputation when question or answer is voted up`() {
            val user = User(1, "Sam", 0, 0, 0, 0)

            user.questionOrAnswerVotedOn(VoteDirection.Up)

            Assertions.assertEquals(1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted up and the user has an initial reputation`() {
            val user = User(1, "Sam", 10, 0, 0, 0)

            user.questionOrAnswerVotedOn(VoteDirection.Up)

            Assertions.assertEquals(11, user.reputation)
        }
    }

    @Nested
    inner class VoteDecreaseTest {

        @Test
        fun `reputation when question or answer is voted down`() {
            val user = User(1, "Sam", 0, 0, 0, 0)

            user.questionOrAnswerVotedOn(VoteDirection.Down)

            Assertions.assertEquals(-1, user.reputation)
        }

        @Test
        fun `reputation when question or answer is voted down and the user has an initial reputation`() {
            val user = User(1, "Sam", 10, 0, 0, 0)

            user.questionOrAnswerVotedOn(VoteDirection.Down)

            Assertions.assertEquals(9, user.reputation)
        }
    }

}