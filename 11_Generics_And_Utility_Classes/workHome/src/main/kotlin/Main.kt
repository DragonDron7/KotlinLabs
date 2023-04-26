import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {

    var team1Count = 0
    var team2Count = 0

    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
    println("\tПрограмма имитирует сражение между двумя командами!")
    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")

    println(" ⤇ Введите, пожалуйста, количество бойцов в 1-й ✪ команде:")

    //  Проверяем вводимое число n на условие n > 0
    while (team1Count <= 0) {
        team1Count = readLine()?.toIntOrNull() ?: 0
        if (team1Count == 0) println("Введите число бойцов больше нуля!")
    }

    println(" ⤇ Введите, пожалуйста, количество бойцов во 2-й ✠ команде:")

    //  Проверяем вводимое число n на условие n > 0
    while (team2Count <= 0) {
        team2Count = readLine()?.toIntOrNull() ?: 0
        if (team2Count == 0) println("Введите число бойцов больше нуля!")
    }

    val battle: Battle = Battle(team1Count, team2Count)
    battle.progress()

}

fun Int.realizedChancer(): Boolean {//ф-ция расширения типа Int, для проверки реализации шанса
    return this >= Random.nextInt(0..100)
}

