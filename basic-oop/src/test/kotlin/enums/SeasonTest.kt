package enums

import org.amshove.kluent.shouldBeEqualTo
import org.example.enums.Seasons
import org.junit.jupiter.api.Test

class SeasonTest {

    @Test
    fun `should return the next season`() {
        val nextSeason = Seasons.Summer.next()

        nextSeason shouldBeEqualTo Seasons.Autumn
    }
}