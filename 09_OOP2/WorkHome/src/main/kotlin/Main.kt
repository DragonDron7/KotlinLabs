import java.math.RoundingMode
import kotlin.random.Random

fun main(args: Array<String>) {

    var sum: Double = 0.0
    val DebitCardVTB = VTBDebitMultiCard(
//создаём дебетовую VTB мультикарту

        balance = 9000.00,//баланс
        cardOwner = "Maria Andreevna",//держатель карты
        cardNumber = "1234 5678 2470 9087",//номер карты
        cashback = Random.nextDouble(0.3, 1.0),//задаем кэшбэк в процентах
        cashbackPlus = Random.nextDouble(1.0, 2.0),//задаем повышенный кэшбэк в процентах
        percentageSave = 0.005// % ставки от суммы пополнений
    )

    println("-------------------Полная информация о балансе и о карте------------")
    DebitCardVTB.getInfoResources()
    //------------------
    sum = 1000.00
    DebitCardVTB.pay(sum)//вызываем метод оплатить
    //------------------
    println("Информация о балансе: ${DebitCardVTB.getBalanceInfo()}")//смотрим баланс

    sum = 4000.00
    println("Пополняем баланс на сумму:$sum")
    DebitCardVTB.topUp(sum)//вызываем метод пополнить

    println("Информация о балансе: ${DebitCardVTB.getBalanceInfo()}")//смотрим баланс

    sum = 0.0
    val CreditCardVTB = VTBCreditMultiCard(
//создаём кредитную VTB мультикарту

        balance = 10000.00,//баланс
        creditLimit = 5000.0,//кредитный лимит
        cardOwner = "Andrey Petrovich",//держатель карты
        cardNumber = "1234 4357 2470 7777",//номер карты
        cashback = Random.nextDouble(0.3, 1.0),//задаем кэшбэк в процентах
        cashbackPlus = Random.nextDouble(1.0, 2.0),//задаем повышенный кэшбэк в процентах
        percentageSave = 0.007// % ставки от суммы пополнений
    )

    println()
    println("============= Другая карта ===========")
    println()

    println("-------------------Полная информация о балансе и о карте------------")
    CreditCardVTB.getInfoResources()
    //------------------
    println("---------------Пополнение баланса-----------")
    sum = 3000.00
    CreditCardVTB.topUp(sum)//вызываем метод пополнить
    //------------------
    println("Информация о балансе: ${CreditCardVTB.getBalanceInfo()}")//смотрим баланс
    //------------------
    sum = Random.nextDouble(100.0, 8000.0)
    println()
    println("---------------Оплата товара-----------")
    CreditCardVTB.pay(sum)//вызываем метод оплатить
    //------------------
    println("Информация о балансе: ${CreditCardVTB.getBalanceInfo()}")



}