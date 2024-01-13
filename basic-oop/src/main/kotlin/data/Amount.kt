package org.example.data

import java.math.BigDecimal

data class Amount(val value: BigDecimal, val currency: String) {

    private val isFractional: Boolean = value.stripTrailingZeros().scale() > 0

    override fun toString(): String {
        return "Amount(value=$value, currency=$currency, isFractional=$isFractional)"
    }
}