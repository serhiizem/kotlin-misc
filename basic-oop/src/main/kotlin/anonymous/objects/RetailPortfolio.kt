package org.example.anonymous.objects

class Position

interface ChangeListener {
    fun onChange()
}

class RetailPortfolio {

    private val _positions = mutableListOf<Position>()
    private val _changeListeners = mutableListOf<ChangeListener>();

    val positions: List<Position>
        get() {
            return _positions.toList()
        }

    fun addPosition(position: Position) {
        _positions.add(position)
        _changeListeners.forEach { it.onChange() }
    }

    fun addPortfolioChangeListener(changeListener: ChangeListener) {
        _changeListeners.add(changeListener)
    }
}