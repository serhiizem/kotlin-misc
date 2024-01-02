package org.example

import java.util.regex.Pattern

val pattern: Pattern = Pattern.compile("\\s+")

fun String.replaceMultipleWhitespaces(): String {
    val regex = pattern.toRegex()
    return regex.replace(this, " ")
}