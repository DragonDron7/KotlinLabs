fun main(args: Array<String>)
{
    var n: Int


    // listPhone

    println("Телефонный справочник")
//1. Проверка на соответствие условию N > 0
// Так же исключаю возникновение ошибки при вводе текстового символа или null-значения, т.к. заменяю их на 0
    do  {
        println("Введите число телефонных номеров, больше нуля:")
        n= readLine()?.toIntOrNull()?:0
    }while (n<=0)

    println()
    //----------
    val phonesMultiList: MutableList<String> = listPhoneNumbers(n)

    println( " Номера телефонов, начинающиеся с приставки +7  ${ phonesMultiList.filter{it.startsWith("+7")}}")/* 5-е задание. */
    println( "Количество уникальных введённых номеров = ${phonesMultiList.toSet().size}")/* 6-е задание. */
    println( "Сумма длин всех введённых номеров телефонов = ${phonesMultiList.sumOf { it.toString().length }}")/* 7-е задание. */
    println()

    val phonesMultiMap: MutableMap<String, String> = listPhoneMultiMap(phonesMultiList)

    phonesMultiMap.forEach { println("Абонент: ${it.value}. Номер телефона: ${it.key} ")/* 9-е задание. */
    }

    println()

    println("Отсортированно по номерам телефона.")/* 10-е задание. */
    phonesMultiMap.toList().sortedBy { (key, value) -> key }
        .toMap().forEach {
            println("Абонент: ${it.value}. " +
                    "Номер телефона: ${it.key} ")
        }
    println()

    println("Отсортированно поимени абонента.")/* 11-е задание. */
    phonesMultiMap.toList().sortedBy { (key,value) -> value }
        .toMap().forEach {
            println(" Абонент: ${it.value}." +
                    " Номер телефона: ${it.key} ")
        }


}


fun listPhoneNumbers(n:Int): MutableList<String>// 4-е задание.
{
    val phonesList = mutableListOf<String>()

    for(i in 1..n)
    {
        println("Введите $i-й номер телефона: ")
        val phoneNumber = readLine().toString() //2. вводим N телефонных номеров пользователей в формате String
        phonesList.add(phoneNumber)        //3. сохраняем введённый номер в список в формате MutableList
    }

    return phonesList
}

fun listPhoneMultiMap(phonesMultiList:MutableList<String>): MutableMap<String,String> /* 8-е задание. */
{
    var name:String
    val phonesMultiMap= mutableMapOf<String,String>()


    phonesMultiList.toSet().forEach {/*вывод без дубликатов номеров*/
        print(" Введите имя человека с номером телефона $it : ")
        name = readln()
        phonesMultiMap[it] = name //ключевое поле телефон (it)
    }
    return   phonesMultiMap

}