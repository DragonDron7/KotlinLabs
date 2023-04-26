import kotlinx.coroutines.*
import java.math.BigInteger



fun main() = runBlocking {/*блокируем вызывающий поток, пока все корутины внутри вызова runBlocking { ... }
 не завершат свое выполнение.*/

    val numbers = listOf(100230, 410801, 6663) // номер в последовательности Фибоначчи
    val sortedNumbers = numbers.sorted()                      // сортировка по возрастанию
    val sortedNumbersDescending = numbers.sortedDescending()  // сортировка по убыванию

    val listFib1 = mutableMapOf<BigInteger, BigInteger>() //создаю пустые изменяемые списки
    val listFib2 = mutableMapOf<BigInteger, BigInteger>()
    var errorMessage: String? = null//хранит сообщение об ошибке, если была ошибка

    val fib1 = launch(Dispatchers.Default) {
        try {
            // сортировка по убыванию
            withTimeout(3400) {

                for (i in sortedNumbersDescending.indices) {

                    listFib1[sortedNumbersDescending[i].toBigInteger()] =
                        Fibonacci.take(sortedNumbersDescending[i].toBigInteger())
                }
            }
        } catch (e: TimeoutCancellationException) {
            errorMessage = "превышено время вычисления!"
        } finally {
            cancel()
        }
    }

    val fib2 = launch(Dispatchers.Default) {
        // сортировка по возрастанию
        for (i in sortedNumbers.indices) {

            listFib2[sortedNumbers[i].toBigInteger()] =
                Fibonacci.take(sortedNumbersDescending[i].toBigInteger())

        }
    }
    launch(Dispatchers.Default) {
        while (fib1.isActive || fib2.isActive) {
            delay(20)
            print(".")
        }
    }

    println("Начало вычисления чисел Фибоначчи")
    fib1.join() // ожидаем завершения корутины
    fib2.join() // ожидаем завершения корутины

    when (errorMessage) {//после завершения 1-й корутины проверяю были ли исключения
        null -> fib1.invokeOnCompletion { println("\n Корутина 1 выполнена без ошибок!") }
        else -> fib1.invokeOnCompletion { println("\n Корутина 1 завершилась с ошибкой: $errorMessage") }
    }
    //после завершения 2-й корутины вывожу сообщение без проверки на ошибки (т.к. нет исключений в ней)
    fib2.invokeOnCompletion { println(" Корутина 2 выполнена без ошибок!") }

    if (listFib1.isNotEmpty()) println("\n Результат 1-й корутины:")
    listFib1.forEach { println(" № ${it.key}, число Фибоначчи = ${it.value}") }

    if (listFib2.isNotEmpty()) println("\n Результат 2-й корутины:")
    listFib2.forEach { println("№ ${it.key}, число Фибоначчи = ${it.value}") }

    println("Программа завершена!")
}





