package org.example.enums

enum class Seasons {
    Winter {
        override fun next() = Spring
    },
    Spring {
        override fun next() = Summer
    },
    Summer {
        override fun next() = Autumn
    },
    Autumn {
        override fun next() = Winter
    };

    abstract fun next(): Seasons
}