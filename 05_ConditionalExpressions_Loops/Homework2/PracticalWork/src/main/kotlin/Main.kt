fun main(args: Array<String>) {
    var n: Int
    //var s:Int

    println("Программа для вычисления n-го числа  из ряда Фибоначчи!")

    // 1. Проверяем вводимое число n на условие n > 0

    do {
        println("Введите, пожалуйста, число больше 0")

        // проверка на ввод числа, иначе присваиваем 0
        n = readLine()?.toIntOrNull() ?: 0
    } while (n <= 0)

    println()

    println("Число Фибоначчи: " + (fibonachi(n)))//3. вывод рассчитанного значения в консоль

}

// 2. Вычисление нужного элемента последовательности
fun fibonachi(n: Int): Int {
    var f1 = 0 //1-е значение ряда Фибоначчи, счиаю от 0!
    var f2 = 1//2- значение -||-
    var count = 3
    var s: Int = 1

    if (n == 1) return 0
    else
        if (n == 2) return 1
        else
            if (n >= 3) {

                for (i in 3..n) {
                    s = f1 + f2
                    f1 = f2;
                    f2 = s
                }
                /*
                                while (count <= n) {

                                    s = f1 + f2
                                    f1 = f2;
                                    f2 = s
                                    count++

                                }*/
            }


    return f2
}





