package github.etx.test

import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.OffsetDateTime
import java.time.OffsetTime
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
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
        val a = subject.nDate
        val b = subject.pDate
        val now = OffsetDateTime.now()

        assertNotEquals(now, a)
        assertNotEquals(now, b)

        assertTrue {
            now.minusDays(10) < a && a < now
        }

        assertTrue {
            now < b && b < now.plusDays(10)
        }
    }

    @Test
    fun randOffsetTime() {
        val result = subject.time
        val now = OffsetTime.now()

        assertNotEquals(now, result)

    }

    @Test
    fun randInstant() {
        val a = subject.nInstant
        val b = subject.pInstant
        val now = Instant.now()

        assertNotEquals(now, a)
        assertNotEquals(now, b)

        assertTrue {
            now.minusSeconds(8 * 24 * 60 * 60) <= a && a <= now
        }

        assertTrue {
            now <= b && b <= now.plusSeconds(8 * 24 * 60 * 60)
        }
    }
}