package org.example.interfaces

import java.math.BigDecimal

class InvestmentOperation(override var amount: BigDecimal) : FinancialOperation, InvestmentStrategy {

    override fun performOperation() {
        super<FinancialOperation>.performOperation()
        super<InvestmentStrategy>.performOperation()
    }
}