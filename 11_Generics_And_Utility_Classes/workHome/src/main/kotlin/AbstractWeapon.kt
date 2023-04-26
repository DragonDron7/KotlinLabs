abstract class AbstractWeapon(
//класс оружия
    private val maxAmmo: Int,  //максимальное кол-во патронов в магазине оружия
    private val fireType: FireType, //вид стрельбы
    private val ammoMagazine: Stack<Ammo>//магазин патронов
) {
    var ammoMagazineIsEmpty = true //факт наличия патронов в магазине
        get() = ammoMagazine.isEmpty()

    abstract fun creatingAmmo(): Ammo  //Создание патрона

    open fun createAmmoMagazine(): Stack<Ammo> { //перезарядка
        if (ammoMagazine.isEmpty()) {//когда пустой магазин
            for (i in 1..maxAmmo) {
                ammoMagazine.push(creatingAmmo())

            }
        } else {//есть сколько-то патронов

            for (i in ammoMagazine.count()..maxAmmo) {
                ammoMagazine.push(creatingAmmo())
                println("Магазин патронов состоит из $maxAmmo шт.")
            }
        }

        return ammoMagazine //возвращаем перезаряженный магазин

    }

    fun getAmmo(): List<Ammo> {
        val list = mutableListOf<Ammo>()// Stack<Ammo>()
        when (fireType) {
            is FireType.SingleShot -> list.add(//выстрел одиночный, добавить один патрон
                (ammoMagazine.pop() as Ammo)//кол-во патронов в магазине уменьшается
            )

            is FireType.FiringBursts -> for (i in 1..fireType.queueSize) {
                list.add((ammoMagazine.pop() ?: createAmmoMagazine()) as Ammo)
            }

        }
        return list //вернет лист отстрелянных патронов
    }

    operator fun plus(weapon: AbstractWeapon): AbstractWeapon {
        return weapon
    }


}

