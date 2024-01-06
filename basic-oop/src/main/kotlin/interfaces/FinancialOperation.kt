package org.example.interfaces

import java.math.BigDecimal

interface FinancialOperation {

    val amount: BigDecimal

    fun performOperation() {}
}