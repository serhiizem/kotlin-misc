package anonymous.objects

import org.amshove.kluent.shouldBeEqualTo
import org.example.anonymous.objects.ChangeListener
import org.example.anonymous.objects.Position
import org.example.anonymous.objects.RetailPortfolio
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