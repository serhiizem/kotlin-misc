package org.example.derivation.accounts

import java.math.BigDecimal

class CheckingAccount(
    override var accountNumber: Int,
    balance: BigDecimal,
    var overdraftLimit: BigDecimal): BankAccount(accountNumber, balance)