import org.amshove.kluent.shouldBeEqualTo
import org.example.replaceMultipleWhitespaces
import org.junit.jupiter.api.Test

class ExtensionFunctionsTest {

    @Test
    fun `should replace multiple whitespaces using extension function`() {
        val initial = "Multiple    whitespaces"

        initial.replaceMultipleWhitespaces() shouldBeEqualTo "Multiple whitespaces"
    }
}