import kotlin.random.Random
import kotlin.random.nextInt


class NatureReserve {//класс Заповедник с животными

   val heron= Bird(//цапля
    Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(1..12), "Sparrow"
    )

    private val animalsMultiList = mutableListOf<Animal>(
        Bird(
            Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(1..12), "Sparrow"
        ),
          Bird(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(3..13), "Оwlo"
          ),
        Bird(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(5..13), "Сhickm"
          ),
          Bird(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(2..10), "Дэвид"
          ),
          Bird(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(5..17), "Цыпа"
          ),
          Fish(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(4..18), "Амурчар"
          ),
          Fish(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(5..11), "Ёршкина"
          ),
          Fish(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(2..30), "Карасян"
          ),
          Dog(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(2..11), "Тимур"
          ),
          Dog(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(2..7), "Люся"
          ),
          Animal(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(2..47), "Йетиновка"
          ),
          Animal(
              Random.nextInt(1..10), Random.nextInt(1..5), Random.nextInt(1..30), "Паразинка"
          )
    )

    fun randomMethod() {
        heron.createChild().drink()//если Animal передать, то доступ к методу закрыт

        val candidatesToRemove=mutableListOf<Animal>()//список зверей на удаление (из-за максимального возраста)
        for (i in 1..4)
            for (j in animalsMultiList.indices) {

                when (Random.nextInt(0 until 4)) {
                    0 -> animalsMultiList[j].sleep()
                    1 -> animalsMultiList[j].eat()
                    2 -> animalsMultiList[j].move()
                    3 -> animalsMultiList.add(animalsMultiList[j].createChild())

                }
                if (animalsMultiList[j].isTooOld) {

                  println("УМЕР(ЛА) ${(animalsMultiList[j].name)} !!! ")
                   candidatesToRemove.add(animalsMultiList[j])//добавляем в список на удаление
                   /* animalsMultiList.removeAt(j) //удаляем у кого возраст больше максимального
                   может вызвать ошибку с переполнением индекса, поэтому через список на удаление! */

                }
                if (animalsMultiList.isEmpty()) {//если все животные исчезли
                    println("Все животные в заповеднике на $i  итерации умерли! ")
                    break
                }

            }
        animalsMultiList.removeAll(candidatesToRemove)
        println("В заповеднике осталось ${animalsMultiList.count()} животных(ое)")
    }

}
