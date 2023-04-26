class VTBCreditMultiCard(
    //кредитная карта
    balance: Double,//баланс
    creditLimit: Double,

    val cardOwner: String,//держатель
    val cardNumber: String,//номер

    val cashback: Double,//кэшбэк
    val cashbackPlus: Double,//повышенный кэшбэк
    val percentageSave: Double //% ставка от суммы пополнений

) : CreditCard(balance, creditLimit) {

    private var cashbackSum: Double = 0.0//общий начисленный кэшбэк

    override fun topUp(sum: Double) {//пополняем баланс
        balance += (sum / 100) * percentageSave//увеличиваем баланс на определенный процент от суммы взноса
        cashbackSum += (sum / 100) * percentageSave//увеличиваем общий кэшбэк за пополнение баланса
        super.topUp(sum)//вызов родительской реализации
        println("Ваш общий кэшбэк за пополнение баланса: ${"%.2f".format(cashbackSum)}")
    }

    override fun getBalanceInfo(): String {
        return "%.2f".format(balance)

    }

    override fun pay(sum: Double): Boolean {//оплатить

        val bol = super.pay(sum)
        if (bol && sum < 5000) {

            cashbackSum += (sum / 100) * cashback.toDouble()//увеличиваем общий кэшбэк

            balance += (sum / 100) * cashback.toDouble()// начисляем кэшбэк за покупку
            // после выполнения родительской реализации, т.е оплаты товара
        } else {
            cashbackSum += (sum / 100) * cashbackPlus.toDouble()
            balance += (sum / 100) * cashbackPlus.toDouble()// начисляем повышенный кэшбэк за покупку
        }
        return bol

    }

    override fun getInfoResources() {//полная информация о балансе и о карте

        println(
            """-----------------------------------------
  Держатель карты: $cardOwner
  Номер карты: $cardNumber"""
        )
        super.getInfoResources()//родительская реализация выполняется
        println(
            """ 
  Ваш кэшбек: ${"%.2f".format(cashback)} при покупке товаров на сумму до  5 000 т.р.
  Ваш повышенный кэшбэк: ${"%.2f".format(cashbackPlus)} при покупке товаров на сумму >= 5 000 т.р.
  Ваша ставка $percentageSave% от суммы пополнения! """
        )
        println()

    }
}