class USDConverter(override val currencyCod: String="USD".trim()) :CurrencyConverter {

    private val rate = 60.80
    private val amountMoney = (1 until 1000).random()
    override fun covertFromRub() {//конвертируем рубли в доллар США
        println("$amountMoney руб. = ${"%.2f".format(amountMoney / rate)} %$currencyCod%")
    }


}