import kotlin.random.Random

open class Animal(//класс открыт для наследования
    var energy: Int = 1,//энергия
    var weight: Int = 1,//вес
    var maxAge: Int = 10,//максимльный возраст
    var name: String = "NoName"//имя

) {
    private var age: Int = 1 //текущий возраст
        set(value) {
            if (value >= 0)
                field = value //блокируем возможность отрицательного возраста
        }

    var isTooOld: Boolean = false //свойство для проверки достижения максимального возраста

    fun sleep() {  //во время сна

        if (age < maxAge) {/*Если животное ещё не слишком старое*/
            energy += 5
            age++
            println("$name спит")
            if (age>=maxAge) isTooOld=true
        }
    }

    fun eat() { //во время питания

        if (age < maxAge) {/*Если животное ещё не слишком старое*/
            energy += 3
            weight++
            tryIncrementAge()
            println("$name ест")
        }
    }

    open fun move(): Boolean { //во время передвижения
        /*Если животное слишком старое, если не хватает веса или энергии для совершения действия,
        то ничего не происходит*/
        return if ((energy >= 5) || (weight >= 2) || (age < maxAge)) {
            energy -= 5
            weight -= 1
            tryIncrementAge()
            println("$name передвигается ")
            true
        } else {
            false
        }
    }

    fun tryIncrementAge() {// если true, то увеличение возраста +1
        if (Random.nextBoolean()) {
            age++
            if (age>=maxAge) isTooOld=true
        }
    }

    open fun createChild(): Animal {
        val child = Animal()
        child.name = name//имя рожденного такое же как и у родителя
        child.maxAge = maxAge//max возраст рожденного
        child.energy = Random.nextInt(1, 10) //энергия
        child.weight = Random.nextInt(1, 5)//вес

        println(
            "Родилось животное по имени ${child.name}, его " +
                    "max возраст= ${child.maxAge}," +
                    "энергия= ${child.energy}," +
                    "вес= ${child.weight}."
        )
        return child
    }
}
