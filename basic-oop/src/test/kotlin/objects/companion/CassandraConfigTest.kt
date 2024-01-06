package objects.companion

import org.amshove.kluent.shouldBeEqualTo
import org.example.objects.companion.CassandraConfig
import org.junit.jupiter.api.Test

class CassandraConfigTest {

    @Test
    fun `should create config through companion object`() {
        val cassandraConfig = CassandraConfig.defaultInstance()

        cassandraConfig.contactPoints shouldBeEqualTo "127.0.0.1"
        cassandraConfig.port shouldBeEqualTo "9042"
    }
}