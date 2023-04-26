

    fun  main()
    {
        val message = """F2p)v"y233{0->c}ttelciFc"""

        //Расшифровываем 1-ю половину сообщения
        val mes1= decode_mes1(message.substring(0,message.length/2))

        //Расшифровываем 2-ю половину сообщения
        val mes2= decode_mes2(message.substring(message.length/2))

        println(mes1+mes2)
    }


    fun decode_mes1 (_mes1:String):String
    {
       var mes1 = _mes1.map {  char -> char+ 1 }.joinToString("")
        mes1 = mes1.replace("5", "s")
        mes1 = mes1.replace("4", "u")
        mes1 = mes1.map {  char -> char - 3 }.joinToString("")
        mes1 = mes1.replace("0", "o")

      return (mes1)
    }

    fun decode_mes2 (_mes2:String):String
        {
            var mes2=_mes2.map { char -> char - 4 }.joinToString("")
            mes2=mes2.replace("_"," ").reversed()
            return (mes2)
        }




