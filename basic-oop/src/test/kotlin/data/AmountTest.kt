package data

import org.amshove.kluent.shouldBeEqualTo
import org.example.data.Amount
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AmountTest {

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