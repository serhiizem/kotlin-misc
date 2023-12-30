package com.stackunderflow

import com.stackunderflow.domain.User
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTestWithPerClassLifecycle {

    private fun usersDataArgumentsSource() = listOf(
        Arguments.of(-1, "Sam")
    );

    @MethodSource("usersDataArgumentsSource")
    @ParameterizedTest
    fun `should test throw exception on invalid id`(id: Int, name: String) {
        assertThrows(IllegalArgumentException::class.java) { User(id, name, 10, 0, 0, 0) }
    }
}