object Channels {
    /* val channelList = mapOf(
         1 to "Первый канал", 2 to "Россия 1", 3 to "Матч!", 4 to "НТВ", 5 to "Пятый канал",
         6 to "Россия К", 7 to "Россия 24", 8 to "Карусель", 9 to "ОТР", 10 to "ТВ Центр",
         11 to "РЕН ТВ", 12 to "Спас", 13 to "СТС", 14 to "Домашний", 15 to "ТВ-3",
         16 to "Пятница!", 17 to "Звезда"
     )
   //

      fun getRandomChannels(channelList:Map<Int,String>) : Set<Pair<Int, String>> {
          val numberOfElements=(1..channelList.count()).random()

          return     channelList.toList().shuffled().take(numberOfElements).toSet()


     }*/

    val channelList = listOf<String>(
        "Первый канал", "Россия 1", "Матч!", "НТВ", "Пятый канал",
        "Россия К", "Россия 24", "Карусель", "ОТР", "ТВ Центр", "РЕН ТВ", "Спас", "СТС",
        "Домашний", "ТВ-3", "Пятница!", "Звезда"
    )

    // var x= Channels.getRandomChannels(channelList)

    fun getRandomChannels(channelList: List<String>): List<String> {
        val numberOfElements = (4..channelList.count()).random()//список не менее 4 каналов
        return channelList.shuffled().take(numberOfElements)
    }


}




