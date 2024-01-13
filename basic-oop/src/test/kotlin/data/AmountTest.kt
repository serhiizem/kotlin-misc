package data

import org.amshove.kluent.shouldBeEqualTo
import org.example.data.Amount
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AmountTest {

    @Test
    fun `should copy data object with different constructor parameter`() {
        val amount = Amount(BigDecimal.ZERO, "USD")
        val changedAmount = amount.copy(currency = "EUR")

        changedAmount.currency shouldBeEqualTo "EUR"
    }

    @Test
    fun `should invoke property initializer during object copy`() {
        val amount = Amount(BigDecimal("12.51"), "USD")
        val amountCopy = amount.copy()

        amountCopy.toString() shouldBeEqualTo "Amount(value=12.51, currency=USD, isFractional=true)"
    }

    @Test
    fun `should be able to destructure data class properties`() {
        val amount = Amount(BigDecimal("6.37"), "EUR")

        val (_, currency) = amount

        currency shouldBeEqualTo "EUR"
    }

    @Test
    fun `should produce equal hash codes fpr equal objects`() {
        val amount = Amount(BigDecimal.ZERO, "USD")
        val otherAmount = Amount(BigDecimal.ZERO, "USD")

        amount.hashCode() shouldBeEqualTo otherAmount.hashCode()
    }

    @Test
    fun `should have overridden toString, including property, omitted from hashCode and equals`() {
        val amount = Amount(BigDecimal.ZERO, "USD")

        amount.toString() shouldBeEqualTo "Amount(value=0, currency=USD, isFractional=false)"
    }
}