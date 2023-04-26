fun main(args: Array<String>) {

    info(TV(brand = "LG", model = "mf43435b", sizeDiagonal = 34))
    info(TV(brand = "Samsung", model = "mf4343435b", sizeDiagonal = 24))
    info(TV(brand = "Sony", model = "ZdS1fherdeh5", sizeDiagonal = 28))


}

fun info(tv: TV) {
    println()
    println("Телевизор: ${tv.brand}, модель ${tv.model}, диагональ: ${tv.sizeDiagonal}")
    //---------
    tv.power()//вкл/выкл ф-ция
    //--------
    print("Увеличение громкости на заданную величину = ")
    println("Громкость стала равна ${tv.volumeUp((readLine()?.toIntOrNull() ?: 0))}")

    ///имитируем нажатие кнопки "+" 10 раз на пульте
    for (i in 0..10) {   /* цикл для проверки функции работы с громкостью*/
        println("Увеличение громкости на 1 +, громкость = ${tv.volumeUp(1)}")
        Thread.sleep(500)
    }


    print("Уменьшение громкости на заданную величину = ")
    println("Громкость стала равна ${tv.volumeDown((readLine()?.toIntOrNull() ?: 0))}")


    //имитируем нажатие кнопки "-" 10 раз на пульте
    for (i in 0..10) {  /* цикл для проверки функции работы с громкостью*/
        println("Уменьшение громкости на 1 -, громкость = ${tv.volumeDown(1)}")
        Thread.sleep(500)
    }



    println("Список каналов: ")
    for (i in tv.list.indices) {//индекс +1 служит в качестве порядкового номера
        println("${(i + 1).toString()}: ${tv.list[i]} ")
    }


    print("Переключения канала на №")
    tv.channelN(readLine()?.trim()?.toIntOrNull() ?: 1)


    println("имитируем нажатие кнопки <Вверх> 10 раз на пульте")
    for (i in 1..10) {  /* цикл для проверки функции работы переход ана следующий канал, эквивалент на пульте +  */

        tv.channelPlus()//Увеличение канала на 1 + (аналог нажатия кнопки переключения каналов «Вверх»)
        Thread.sleep(500)
    }

    println()
    println("имитируем нажатие кнопки <Вниз> 10 раз на пульте")

    for (i in 1..10) {  /* цикл для проверки функции работы перехода на предыдущий канал, эквивалент на пульте -  */

        tv.channelMinus()//Уменьшение канала на 1 - (аналог нажатия кнопки переключения каналов «Вниз»)
        Thread.sleep(500)
    }

}





