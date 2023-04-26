class EuroConverter(override val currencyCod: String = "EUR ".trim()) : CurrencyConverter {

    private val rate = 60.70//курс
    private val amountMoney = (1 until 1000).random()
    override fun covertFromRub() {//конвертируем рубли в Евро
        println("$amountMoney руб. = ${"%.2f".format(amountMoney / rate)} %$currencyCod%")
    }


}