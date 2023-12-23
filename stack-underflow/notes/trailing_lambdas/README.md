#### Passing trailing lambdas

According to Kotlin convention, if the last parameter of a function is a function, then a lambda expression passed as the corresponding argument can be placed outside the parentheses:

```kotlin
val product = items.fold(1) { acc, e -> acc * e }
```
Such syntax is also known as trailing lambda.

If the lambda is the only argument in that call, the parentheses can be omitted entirely:

```kotlin
run { println("...") }
```

https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas