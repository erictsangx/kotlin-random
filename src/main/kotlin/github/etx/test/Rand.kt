package github.etx.test

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
     * [OffsetDateTime.now] minus [0,7] days
     */
    val nDate: OffsetDateTime
        get() {
            return OffsetDateTime.now().minusDays(int(0, 7).toLong())
        }

    /**
     * [OffsetDateTime.now] plus [1,7] days
     */
    val pDate: OffsetDateTime
        get() {
            return OffsetDateTime.now().plusDays(int(1, 7).toLong())
        }

    /**
     * [OffsetTime.now] minus [0,7] hours
     */
    val nTime: OffsetTime
        get() {
            return OffsetTime.now().minusHours(int(0, 7).toLong())
        }

    /**
     * [OffsetTime.now] plus [1,7] hours
     */
    val pTime: OffsetTime
        get() {
            return OffsetTime.now().plusHours(int(1, 7).toLong())
        }

    /**
     * [Instant.now] minus [0,7] hours
     */
    val nInstant: Instant
        get() {
            return Instant.now().minusSeconds((int(0, 7).toLong() * 24 * 60 * 60))
        }

    /**
     * [Instant.now] plus [1,7] hours
     */
    val pInstant: Instant
        get() {
            return Instant.now().plusSeconds(int(1, 7).toLong() * 24 * 60 * 60)
        }

}