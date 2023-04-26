import kotlin.random.Random

class Fish( //дочерний класс рыба
    energyArg: Int=1,//энергия
    weightArg: Int=1,//вес
    maxAgeArg: Int=10,//максимльный возраст
    nameArg: String= "NoName"//имя

) : Animal(energy = energyArg, weight = weightArg, maxAge = maxAgeArg, name = nameArg) {

    override fun move(): Boolean {
        val bol = super.move()//вызов родительской реализации
        if (bol) println("плывёт")//вывод сообщения только при выполнении родительской реализации
        return bol
    }

    override fun createChild(): Fish{
        val child = Fish()
        child.name = name//имя рожденного такое же как и у родителя
        child.maxAge = maxAge//max возраст рожденного
        child.energy = Random.nextInt(1, 10) //энергия
        child.weight = Random.nextInt(1, 5)//вес

        println(
            "Родилась рыба по имени ${child.name}, его " +
                    "max возраст= ${child.maxAge}," +
                    "энергия= ${child.energy}," +
                    "вес= ${child.weight}."
        )
        return child
    }
}