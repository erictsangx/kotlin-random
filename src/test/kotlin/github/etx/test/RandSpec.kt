package github.etx.test

import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.OffsetDateTime
import java.time.OffsetTime
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RandSpec {
    val subject = Rand

    @Test
    fun defaultRandInt() {
        val a = subject.int
        assertTrue { a in 0..100 }

        val b = subject.int(0, 1)
        assertTrue { b in 0..1 }
    }

    @Test
    fun randString() {
        val result = subject.str
        assertFalse(result.contains("-"))
        assertEquals(result.length, 32)
    }

    @Test
    fun randOffsetDateTime() {
        val a = subject.nDate.withHour(0).withMinute(0).withSecond(0).withNano(0)
        val b = subject.pDate.withHour(0).withMinute(0).withSecond(0).withNano(0)
        val now = OffsetDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0)

        assertTrue {
            now.minusDays(7) <= a && a <= now
        }

        assertTrue {
            now.plusDays(1) <= b && b <= now.plusDays(7)
        }
    }

    @Test
    fun randOffsetTime() {
        val a = subject.nTime.withSecond(0).withNano(0)
        val b = subject.pTime.withSecond(0).withNano(0)
        val now = OffsetTime.now().withSecond(0).withNano(0)

        assertTrue {
            now.minusHours(7) <= a && a <= now
        }

        assertTrue {
            now.plusHours(1) <= b && b <= now.plusHours(7)
        }
    }

    @Test
    fun randInstant() {
        val a = subject.nInstant
        val b = subject.pInstant
        val now = Instant.now()

        assertTrue {
            now.minusSeconds(7 * 24 * 60 * 60) <= a && a <= now
        }

        assertTrue {
            now.plusSeconds(1 * 24 * 60 * 60) <= b && b <= now.plusSeconds(7 * 24 * 60 * 60)
        }
    }
}