fun main(args: Array<String>) {

    val listCurrency = listOf<String>("USD "," eUR ", "FRF","DON") //список международных кодов валют
    val index = (0 until listCurrency.count()).random()

    Converters.get(listCurrency[index]).covertFromRub()//вызываем конвертер случайным образом

}


