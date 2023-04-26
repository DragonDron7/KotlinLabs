
class Player(private var index: Int, private val cardsCount: Int) { //игрок

    private val ticketsLoto = mutableListOf<Array<Array<String>>>() //список игральных билетов у игрока
    private val winKegsCount: MutableList<Int> =
        MutableList(cardsCount) { 0 }//список для каждого билета из количества совпадений с выпавшими бочонками

    fun getGameTicket() {
        if (cardsCount > 0) {

            println("\t Игрок № $index получил игральные билет(ы):")
            for (i in 1..cardsCount) {
                ticketsLoto.add(Ticket().gameTicket())
                // Ticket().gameTicket().collect { ticketsLoto.add(it) }
            }
            ticketsLoto.forEach { ticket ->
                gameTicket(ticket)
            }
        }
    }

    private fun gameTicket(ticket: Array<Array<String>>) {//выводим на экран игральный билет
        println("⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ Игральная карточка ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺")
        for (row in ticket.indices) {//идём по строкам
            for (cell in 0 until ticket[row].size) { // идём по ячейкам в строке
                print("||\t${ticket[row][cell]}\t")
            }
            println("||")
        }
        println("⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺")
    }

    fun game(keg: Int): Boolean {

        val column = if (keg / 10 == 9) 8 else keg / 10  //определяем столбец поиска (для экономии ресурсов)
        ticketsLoto.forEach { ticket ->

            for (row in ticket.indices) {//идём по строкам
                if (ticket[row][column] == keg.toString())//есть совпадение
                {
                    winKegsCount[ticketsLoto.indexOf(ticket)]++ //увеличиваем счётчик совпадений в конкретном билете
                    ticket[row][column] = "><"
                    println("\t У игрока № $index есть совпадение, бочонок с номером ${keg}:")
                    gameTicket(ticket) //печатаем билет


                    if (winKegsCount[ticketsLoto.indexOf(ticket)] == 15) {
                        println("\t Игрок № $index победил, заполнены все номера в игровом билете!")
                        return true
                    }
                    break //нашли, дальше не ищем
                }
            }
        }
        return false
    }
}






