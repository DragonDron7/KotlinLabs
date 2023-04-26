fun main() {


    val normalPressure = 2.0  //нормальное давление
    val abnormalPressure = 5.5//неправильное давление
    val impossible = -2.0       //невозможное давление
    val wheel = Wheel()
    val listPressure = listOf(normalPressure, abnormalPressure, impossible)

    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
    println("\tПрограмма имитирует данные датчика колеса!")
    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")


    for (i in listPressure.indices) {

                println(" ⤇ Колесо накачиваем до ${listPressure[i]} атмосфер")
                try {
                    wheel.pumpWheel(listPressure[i])
                } catch (e: TooHighPressure) {
                    println(TooHighPressure().message)
                } catch (e: TooLowPressure) {
                    println(TooLowPressure().message)

                } catch (e: IncorrectPressure) {
                    println(IncorrectPressure().message)
                }

                println("  ⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺⟺ ")
            }

}

class TooHighPressure : Throwable("Эксплуатация невозможна - давление превышает нормальное.")
class TooLowPressure : Throwable("Эксплуатация невозможна - давление ниже нормы.")
class IncorrectPressure : Throwable("Давление в шине недопустимое!")
