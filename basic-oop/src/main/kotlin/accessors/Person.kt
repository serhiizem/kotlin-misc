package org.example.accessors

class Person {
    var name: String = ""
        set(value) {
            if (value.isEmpty()) throw Exception("Name can not be empty")
            field = value
        }
    var calories = 0

    val hasEaten: Boolean
        get() = calories != 0

    fun feed(food: String) {
        updateCalories(100)
    }

    private fun updateCalories(caloriesValue: Int) {
        calories += caloriesValue
    }
}