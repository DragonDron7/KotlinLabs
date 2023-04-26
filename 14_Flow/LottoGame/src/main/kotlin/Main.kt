fun main() {

    var cardsCount = 0  //кол-во игральных карт
    var playerCount = 0 //кол-во игроков

    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
    println("\t\t\t           Игра лото")
    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")

    println(" ⤇ Введите количество игроков:")

    //  Проверяем вводимое число n на условие n > 1
    while (playerCount <= 1) {
        playerCount = readLine()?.toIntOrNull() ?: 1
        if (playerCount == 1) println("Введите число игроков больше одного!")
    }
    println(" ⤇ Введите количество игральных билетов у игрока:")
    while (cardsCount <= 0) {
        cardsCount = readLine()?.toIntOrNull() ?: 0
        if (cardsCount == 0) println("Введите число билетов больше нуля!")
    }

    Players(playerCount, cardsCount).getPlayers()

}








