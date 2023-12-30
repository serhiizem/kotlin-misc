#### Infix notation

Functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call). Infix functions must meet the following requirements:

* They must be member functions or extension functions.
* They must have a single parameter.
* The parameter must not accept variable number of arguments and must have no default value.

```kotlin
infix fun Int.shl(x: Int): Int { ... }

// calling the function using the infix notation
1 shl 2

// is the same as
1.shl(2)
```

https://kotlinlang.org/docs/functions.html#infix-notation