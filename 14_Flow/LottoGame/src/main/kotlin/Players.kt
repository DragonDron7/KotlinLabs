import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.shareIn

class Players(
    // игроки (соперники)
    private val playerCount: Int, //кол-во игроков
    private val cardsCount: Int,  //кол-во игральных карт
) {
    private var winCount = 0 //кол-во победителей
    private var hod = 0 //№ хода

    private val playersLoto: MutableList<Player> = mutableListOf() //список игроков

    private var gameIsOver = false//определяет окончание игры
    private val winner: MutableList<Boolean> =
        MutableList(playerCount) { false }//список с параметром для каждого игрока, определяющим победу

    fun getPlayers() {
        runBlocking {
            launch() {

                var i = 0    // индекс игрока, чтобы каждому не указывать имя
                if (playerCount > 0) {
                    for (k in 1..playerCount) {
                        val player = Player(index = ++i, cardsCount)
                        player.getGameTicket()  //показываем билет(ы) каждого игрока
                        playersLoto.add(player)
                    }
                }

                while (!gameIsOver) {//пока нет победителя, играем
                    // startGame(Generator.randomNumber() ) //получаем бочонок из "мешка" ...
                    Generator.randomNumber().collect { keg -> startGame(keg) }
                }

                winner.forEach { winner -> if (winner) winCount++ }//считаем кол-во победителей

                println("\n\t  ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
                if (winCount > 1) {
                    println("\t\t\t\t\t Игроки победители:")

                    for (index in winner.indices) {
                        if (winner[index]) {
                            println("\t\t\t\t\t\t Игрок № ${(index) + 1}!")
                        }
                    }
                }
                if (winCount == 1) {
                    winner.forEach { if (it) println("\t\t\t\t\t\t Игрок № ${winner.indexOf(it) + 1} победил!") }
                }
                println("\t  ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
                println("Игра закончена!!!")
            }
        }
    }

    private fun startGame(keg: Int) {
        runBlocking {
            println("Ход ${++hod}: достали бочонок с номером: $keg")

            playersLoto.forEach { player ->
                launch() {
                    winner[playersLoto.indexOf(player)] = player.game(keg)//каждый игрок сообщает победил он или нет

                    winner.forEach { winner ->

                        if (winner) //если есть победитель, останавливаем игру
                            gameIsOver = true
                        yield()
                        cancel()

                    }

                }


            }
        }
    }


}