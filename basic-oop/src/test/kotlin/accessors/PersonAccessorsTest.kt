package accessors

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldThrow
import org.amshove.kluent.withMessage
import org.example.accessors.Person
import org.junit.jupiter.api.Test

class PersonAccessorsTest {

    @Test
    fun `should not be able to assign empty name`() {
        val person = Person()

        invoking { run { person.name = "" } } shouldThrow Exception::class withMessage "Name can not be empty"
    }

    @Test
    fun `should consider has not eaten when empty calories`() {
        val person = Person()

        person.calories shouldBeEqualTo 0
        person.hasEaten shouldBeEqualTo false
    }

    @Test
    fun `should consider has eaten when calories were consumed`() {
        val person = Person()

        person.feed("Food")

        person.calories shouldBeEqualTo 100
        person.hasEaten shouldBeEqualTo true
    }
}