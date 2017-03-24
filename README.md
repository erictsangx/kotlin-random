# kotlin-random

A very simple lib of Java Random and Kotlin aims to make testing easier, no magic. 
Also support Java8 OffsetTime, OffsetDateTime and Instant


## Examples:
```kotlin
val a = Rand.int
val b = Rand.bool // the same as Random().nextBoolean()

val timeA = Rand.nTime //[OffsetTime.now] minus [0,7] hours
val timeB = Rand.pTime //[OffsetTime.now] plus [0,7] hours

```

## Extensions
```kotlin
class Foo(name: String, age: Int)

val Rand.foo: Foo
    get() = Foo(str, int)
```