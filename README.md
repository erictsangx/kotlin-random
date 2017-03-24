# kotlin-random

A very simple lib of Java Random and Kotlin aims to make testing easier, no magic. 
Also support Java8 OffsetTime, OffsetDateTime and Instant

## Gradle
```gradle
compile "io.github.erictsangx:kotlin-random:0.0.1"
```

## Maven
```maven
<dependency>
  <groupId>io.github.erictsangx</groupId>
  <artifactId>kotlin-random</artifactId>
  <version>0.0.1</version>
</dependency>
```
## Examples:
```kotlin
val a = Rand.int  // 1-100 by default
val b = Rand.str  // 3feffb92c82745a3b6ccd5f9fec5e3f1
val c = Rand.bool // same as Random().nextBoolean()

val timeA = Rand.time // 15:52:23.130+08:00
val dataA = Rand.nDate //[OffsetDateTime.now] - [1,7] days - [Rand.time]
val dataB = Rand.pDate //[OffsetDateTime.now] + [1,7] days + [Rand.time]

```

## Extensions
```kotlin
class Foo(name: String, age: Int)

val Rand.foo: Foo
    get() = Foo(str, int)
```