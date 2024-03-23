package sealed

import org.amshove.kluent.shouldBeEqualTo
import org.example.sealed.SealedError
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SealedErrorTest {

    companion object {
        @JvmStatic
        fun errorsMethodSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(SealedError.DatabaseError("ORA-00904"), false),
                Arguments.of(SealedError.NetworkError(99), true),
                Arguments.of(SealedError.NetworkError(100), false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("errorsMethodSource")
    fun `should determine if code is safe to proceed`(error: SealedError, expectedResult: Boolean) {
        val isSafeToProceed = when (error) {
            is SealedError.DatabaseError -> false
            is SealedError.NetworkError -> error.isSafeToProceed()
        }

        isSafeToProceed shouldBeEqualTo expectedResult
    }
}