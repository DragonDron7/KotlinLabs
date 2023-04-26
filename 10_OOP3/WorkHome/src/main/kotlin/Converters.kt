object Converters {

    private val listConverter = listOf<CurrencyConverter>(EuroConverter(), USDConverter()) //список конверторов валют


    fun get(currencyCod: String): CurrencyConverter {

        return listConverter.find { it.currencyCod == currencyCod.uppercase().trim() } ?: object : CurrencyConverter {

            override val currencyCod: String? = null
            override fun covertFromRub() {
                println("Международный код валюты $currencyCod не найден!")
            }

        }
    }


}
