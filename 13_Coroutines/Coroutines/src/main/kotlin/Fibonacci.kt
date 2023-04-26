import kotlinx.coroutines.yield
import java.math.BigInteger

object Fibonacci {

    // Вычисление нужного элемента последовательности Фибоначчи

    suspend fun take(index: BigInteger): BigInteger {
        yield()//приостановит корутину и тут же возобновит, но попути обработает сигнал завершения
        if (index < BigInteger.ZERO) {
            throw IndexOutOfBoundsException("Вы ввели отрицательное число: $index, введите положительное число! ")
        }
        if (index == BigInteger.ZERO) {
            return BigInteger.ZERO
        }

        var n0 = BigInteger.ZERO
        var n1 = BigInteger.ONE
        var i = 3.toBigInteger()
        while (i <= index) {
            val n2 = n0 + n1
            n0 = n1
            n1 = n2
            i++
        }
        return n1
    }
}
