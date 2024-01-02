package derivation

import org.amshove.kluent.shouldBeEqualTo
import org.example.derivation.accounts.BankAccount
import org.example.derivation.accounts.CheckingAccount
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CheckingAccountTest {

    @Test
    fun `should inherit properties from parent`() {
        val accountNumber = 1
        val balance = BigDecimal("3161.36")
        val overdraftLimit = BigDecimal("1000")
        val checkingAccount = CheckingAccount(accountNumber, balance, overdraftLimit)

        checkingAccount.accountNumber shouldBeEqualTo accountNumber
        checkingAccount.balance shouldBeEqualTo balance
        checkingAccount.overdraftLimit shouldBeEqualTo overdraftLimit
    }

    @Test
    fun `should be able to override property with broadened access`() {
        val bankAccount = BankAccount(1, BigDecimal("5135.71"))
        val checkingAccount = CheckingAccount(2, BigDecimal("3161.36"), BigDecimal("1000"))

        // can be modified due to overridden property with increased access
        checkingAccount.accountNumber = 3

        bankAccount.accountNumber shouldBeEqualTo 1
        checkingAccount.accountNumber shouldBeEqualTo 3
    }
}