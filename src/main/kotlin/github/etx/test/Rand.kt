package github.etx.test

import java.time.Duration
import java.time.Instant
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.util.*


object Rand {

    /**
     * random int inclusively [min,max]
     * @param min lower bound
     * @param max upper bound
     * @see [Random.nextInt]
     */
    fun int(min: Int, max: Int): Int = min + Random().nextInt((max - min) + 1)

    val int: Int
        get() {
            return int(0, 100)
        }

    /**
     * @see [Random.nextLong]
     */
    val long: Long
        get() {
            return Random().nextLong()
        }

    /**
     * @see [Random.nextDouble]
     * [0.0d,1.0d)
     */
    val double: Double
        get() {
            return Random().nextDouble()
        }
    /**
     * @see [Random.nextFloat]
     * [0.0f,1.0f)
     */
    val float: Float
        get() {
            return Random().nextFloat()
        }

    /**
     * @see [UUID.randomUUID]
     */
    val str: String
        get() {
            return UUID.randomUUID().toString().replace("-", "")
        }

    /**
     * @see [Random.nextBoolean]
     */
    val bool: Boolean
        get() {
            return Random().nextBoolean()
        }


    /**
     * random OffsetTime
     */
    val time: OffsetTime
        get() {
            return OffsetTime.now() + timeDuration()
        }

    /**
     * [OffsetDateTime.now] - [1,7] days - [time]
     */
    val nDate: OffsetDateTime
        get() {
            return OffsetDateTime.now() - datetimeDuration()
        }

    /**
     * [OffsetDateTime.now] + [1,7] days + [time]
     */
    val pDate: OffsetDateTime
        get() {
            return OffsetDateTime.now() + datetimeDuration()
        }

    /**
     * [Instant.now] - [1,7] days - [time]
     */
    val nInstant: Instant
        get() {
            return Instant.now() - datetimeDuration()
        }

    /**
     * [Instant.now] + [1,7] days + [time]
     */
    val pInstant: Instant
        get() {
            return Instant.now() + datetimeDuration()
        }

    private fun timeDuration(): Duration = Duration.ofHours(int(1, 23).toLong()) +
        Duration.ofMinutes(int(1, 59).toLong()) +
        Duration.ofSeconds(int(1, 59).toLong())

    private fun datetimeDuration(): Duration = Duration.ofDays(int(1, 7).toLong()) + timeDuration()
}