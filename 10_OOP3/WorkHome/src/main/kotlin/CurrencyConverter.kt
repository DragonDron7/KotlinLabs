interface CurrencyConverter {
    val currencyCod: String? //международный код валюты

    fun covertFromRub()//конвертирует рубли в валюту, назвал метод иначе, чем в задание (convertToRub), так корректней

}