open class CreditCard(balance: Double, private val creditLimit: Double) : BankCard(balance) {

    private var credit = creditLimit


    override fun topUp(sum: Double) {//пополнить баланс карты
        if (sum > 0 && credit == creditLimit) {
            balance += sum
            println("Баланс пополнен на ${"%.2f".format(sum)}")
            infoTopUp()

        } else if (credit + sum <= creditLimit) {
            credit += sum
            println("Баланс пополнен на ${"%.2f".format(sum)}")
            infoTopUp()

        } else if (credit + sum > creditLimit) {
            val money = creditLimit - credit
            val money1 = sum - money
            credit += money //недостающая сумма кредитного лимита
            balance += money1//остаток идет на пополнение баланса
            println("Баланс пополнен на ${"%.2f".format(sum)}")
            infoTopUp()
        }

    }

    private fun infoTopUp() {//информация о средствах на карте
        println(
  """Кредитные средства: ${"%.2f".format(credit)}
  Собственные средства: ${"%.2f".format(balance)}
  """
        )
    }

    override fun pay(sum: Double): Boolean {//оплатить картой
        if (balance >= sum) {
            balance -= sum
            println("Товар оплачен на сумму: ${"%.2f".format(sum)}")
            return true
        } else if (balance + credit >= sum) {//если не хватает собственных средств и хватает с учетом кредита
            credit -= (sum - balance)

            println("Оплата: ${"%.2f".format(sum)} произведена!")
            infoTopUp()

            return true

        } else println("Недостаточно средств для совершения оплаты!")
        return false
    }

    override fun getBalanceInfo(): String {//баланс без кредитных средств
        return "%.2f".format(balance)
    }

    override fun getInfoResources() {//полная информация о балансе
        println("Кредитная карта с лимитом: ${"%.2f".format(creditLimit)} ")
        println("Ваш баланс: ${getBalanceInfo()} ")
    }
}