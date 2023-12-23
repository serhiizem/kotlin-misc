#### Late-initialized properties and variables

```kotlin
class MyTest {
    lateinit var subject: TestSubject

    @SetUp fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()
    }
}
```

https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables