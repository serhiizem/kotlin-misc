#### Companion objects
An object declaration inside a class can be marked with the companion keyword:

```kotlin
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
```

Members of the companion object can be called simply by using the class name as the qualifier:

```kotlin
val instance = MyClass.create()
```

https://kotlinlang.org/docs/object-declarations.html#companion-objects