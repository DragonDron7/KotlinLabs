class Wheel(private var Pressure: Double = 0.0) {//колесо

    fun pumpWheel(currentPressure: Double) { //функция накачки колеса

        //проверка на недопустимое давление
        if (currentPressure < MinPressure || currentPressure > MaxPressure){
            println(  "При накачке $currentPressure атмосфер процедура не удалась.")
            throw IncorrectPressure()}
        else {
            println("При накачке $currentPressure атмосфер процедура удалась.")
            Pressure = currentPressure
            checkPressure(currentPressure)
        }
    }

    private fun checkPressure(currentPressure: Double) { //функция проверки давления в колесе

        //проверка давления на допустимость эксплуатации колеса
        if (currentPressure < NormalPressureMin) throw TooLowPressure()
        if (currentPressure > NormalPressureMax) throw TooHighPressure()
        else {
            println(" Эксплуатация возможна.")
        }
    }

    companion object {

        //давление в колесе
        const val MinPressure = 0.0       //меньше нельзя (вакуум без давления, покрышка не держит)
        const val MaxPressure = 10.0      //больше нельзя (разрыв шины)
        const val NormalPressureMin = 1.6 //минимальное нормальное давление
        const val NormalPressureMax = 2.5  //максимальное нормальное давление
    }
}