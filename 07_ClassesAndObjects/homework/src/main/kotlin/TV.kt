import Channels.channelList

class TV(
    var brand: String = "none",//свойство марка
    var model: String = "none",//свойство модель
    var sizeDiagonal: Byte = 0,//свойство размер диагонали
    onOff_param: Boolean = false,//параметр вкл/выкл
    var volume: Int = 0//начальная громкость


) {
    var list = Channels.getRandomChannels(channelList)//случайный список каналов
    var onOff = onOff_param
        private set /* свойство доступно для чтения и недоступно для записи;*/

    var channelActive: Int = 0//хранит индекс активного канал

    /*Ф-ция увеличения громкости*/
    fun volumeUp(v: Int): Int {

        if ((volume + v) > maximumVolume) {
            return maximumVolume
        } else {
            volume += v
            return volume
        }

    }

    /*Ф-ция уменьшения громкости*/
    fun volumeDown(v: Int): Int {

        return if ((volume - v) < 0) {
            0
        } else {
            volume -= v
            volume
        }

    }


    /* Ф-ция вкл/выкл */
    fun power() {
        if (!onOff) {
            onOff = true
            println("ТВ включен")

        } else {
            onOff = false
            println("ТВ выключен")

        }


    }

    /*включение определенного канала*/
    fun channelN(n: Int) {

        if (!onOff) {
            onOff = true
        }//если телек выкл, то вкл, и переключим на заданный канал
        println("Канал ${n}:  ${list[n - 1]} (включен)")
        println()
        channelActive = n - 1//запоминаем индекс активного канала

    }

    /*переход на предыдущий канал в списке*/
    fun channelMinus() {

        if (!onOff) {
            onOff = true
        }//если телек выкл, то вкл, и переключим на заданный канал


        //проверка рамок стека индексов списка
        if (channelActive == 0) {//если канал первый в списке каналов, начинаем с последнего, и так по кругу
            channelActive = list.size
        }
        channelActive--
        println("Уменьшение канала на 1 -, канал = ${list[channelActive]}")

    }

    /*переход на предыдущий канал в списке*/
    fun channelPlus() {

        if (!onOff) {
            onOff = true
        }//если телек выкл, то вкл, и переключим на заданный канал

        /*  for (i in channelActive..list.size-1) {   /* цикл для переключения каналов в порядке возрастания*/
              println("Увеличение канала на 1 +, канал = ${list[i]}")}*/

        channelActive++
        if (channelActive == list.size) {//если канал последний в списке каналов, начинаем сначала списка и так по кругу
            channelActive = 0
        }
        println("Увеличение канала на 1 +, канал = ${list[channelActive]}")

    }

    companion object {
        const val maximumVolume: Int = 100
    }
}











