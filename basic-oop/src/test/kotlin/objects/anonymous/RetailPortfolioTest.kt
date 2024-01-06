package objects.anonymous

import org.amshove.kluent.shouldBeEqualTo
import org.example.objects.anonymous.ChangeListener
import org.example.objects.anonymous.Position
import org.example.objects.anonymous.RetailPortfolio
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicBoolean

class RetailPortfolioTest {

    @Test
    fun `should add anonymous change listener to client portfolio`() {
        val retailPortfolio = RetailPortfolio()
        val changeRef = AtomicBoolean(false)

        retailPortfolio.addPortfolioChangeListener(object : ChangeListener {
            override fun onChange() {
                changeRef.set(true)
            }
        })

        retailPortfolio.addPosition(Position())

        changeRef.get() shouldBeEqualTo true
    }
}