import java.math.RoundingMode

open class DebitCard(balance: Double) : BankCard(balance) {

    override fun topUp(sum: Double) {//пополнить
        if (sum > 0) balance += sum
    }

    override fun pay(sum: Double): Boolean {//оплатить
        if (balance >= sum) {
            balance -= sum
            println("Товар оплачен на сумму: ${"%.2f".format(sum)}")
            return true
        } else
            println("Недостаточно средств для совершения оплаты!")
        return false
    }

    override fun getBalanceInfo(): String {//получить информацию о балансе
        return "%.2f".format(balance)
    }

    override fun getInfoResources() {//полная информация о балансе
        println("""
   У Вас дебетовая карта! 
   Ваш баланс: ${"%.2f".format(balance)}
 -----------------------------------------""")

    }


}