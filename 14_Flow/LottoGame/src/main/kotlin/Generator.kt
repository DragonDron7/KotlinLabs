import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

object Generator {
    //генератор чисел (ведущий)
    private val playingKegs = mutableListOf<Int>()//создаю "мешок" для бочонков

    init {
        (1..90).shuffled().forEach { keg -> playingKegs.add(keg) }//перемешиваю и складываю игральные бочонки в мешок
    }

    fun randomNumber() = flow {

        if (playingKegs.size != 0 && currentCoroutineContext().isActive) {//если в "мешке" ещё есть бочонки, вытаскиваем
            /* перемешиваем и выбираем 1 бочонок из "мешка")  */
            val keg = playingKegs.shuffled()[playingKegs.indices.random()]
            playingKegs.remove(keg)
            emit(keg) //передаём в поток
        }
    }
}