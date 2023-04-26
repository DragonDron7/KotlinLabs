class Ticket { //Генератор билетов

    /*Создаётся игральная карта по правилам:
    1) В игре принимает участие 90 бочонков
    2) Игровая карточка состоит из 3 строк, в каждой из них по 9 клеток, 5 из которых занимают числа
    3) Числа на одной карточке не могут повторяться
    4) Расположить числа (по строке) на карточке в порядке возрастания

    // Пункты 5-6 реализовал для души, как в настоящих игральных картах

    5) В каждой колонке карты может быть 1 или 2 числа (не 0 и не 3)
    6) Колонки заполняются по правилам:
        1-й столбик - числа от 1 до 9
        2-й столбик - числа от 10 до 19
        3-й столбик - числа от 20 до 29
            ... по одному десятку
        9-й столбик - числа от 80 до 90
     */

    private val ticket = Array(3) { Array(9) { "_" } } //2d массив, представляющий карточку лото

    private val firstRow = (0..8).shuffled().take(5)    //получаем номера ячеек, в которых будут значения
    private val secondRow = (0..8).shuffled().take(5)   //получаем номера ячеек, в которых будут значения
    private var thirdRowCount = 0   //количество не пустых значений в 3-ем ряду

    fun gameTicket(): Array<Array<String>> {//создаём игральный билет

        for (row in ticket.indices) {//идём по строкам
            for (cell in 0 until ticket[row].size) { // идём по ячейкам в строке

                firstRow.forEach { if (it == cell) ticket[0][it] = numbersTicket(it)[0].toString() }
                secondRow.forEach { if (it == cell) ticket[1][it] = numbersTicket(it)[1].toString() }

                if (thirdRowCount < 5) {//заполняем пустые колонки (должен быть хоть 1 элемент в колонке)

                    if (ticket[0][cell] == "_" && ticket[1][cell] == "_" && ticket[2][cell] == "_") {
                        ticket[2][cell] = numbersTicket(cell)[2].toString()
                        thirdRowCount++
                    }
                }
            }
        }
        //оставшиеся элементы из 3-го ряда распределяем
        for (row in ticket.indices) {//идём по строкам
            for (cell in 0 until ticket[row].size) { // идём по ячейкам в строке
                if (thirdRowCount < 5) {
                    if ((ticket[0][cell] == "_" || ticket[1][cell] == "_") && ticket[2][cell] == "_") {
                        ticket[2][cell] = numbersTicket(cell)[2].toString()
                        thirdRowCount++
                    }
                }
            }
        }
        return ticket
    }

    private fun numbersTicket(index: Int): List<Int> = when (index) {
        0 -> numbersForColumn0
        1 -> numbersForColumn1
        2 -> numbersForColumn2
        3 -> numbersForColumn3
        4 -> numbersForColumn4
        5 -> numbersForColumn5
        6 -> numbersForColumn6
        7 -> numbersForColumn7
        8 -> numbersForColumn8
        else -> throw IllegalArgumentException("Недопустимое значение параметра столбца!")
    }

    private companion object { //для инициализации переменных один раз (числа в билете будут без повтора)
        private val numbersForColumn0 = ((1..9).shuffled().take(3))
        private val numbersForColumn1 = ((10..19).shuffled().take(3))
        private val numbersForColumn2 = ((20..29).shuffled().take(3))
        private val numbersForColumn3 = ((30..39).shuffled().take(3))
        private val numbersForColumn4 = ((40..49).shuffled().take(3))
        private val numbersForColumn5 = ((50..59).shuffled().take(3))
        private val numbersForColumn6 = ((60..69).shuffled().take(3))
        private val numbersForColumn7 = ((70..79).shuffled().take(3))
        private val numbersForColumn8 = ((80..90).shuffled().take(3))
    }
}