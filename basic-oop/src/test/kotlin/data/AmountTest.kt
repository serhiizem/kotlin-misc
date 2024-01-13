package data

import org.amshove.kluent.`should be equal to`
import org.example.data.Amount
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AmountTest {

    @Test
    fun `should produce equal hash codes fpr equal objects`() {
        val amount = Amount(BigDecimal.ZERO, "USD")
        val otherAmount = Amount(BigDecimal.ZERO, "USD")

        amount.hashCode() `should be equal to` otherAmount.hashCode()
    }
}