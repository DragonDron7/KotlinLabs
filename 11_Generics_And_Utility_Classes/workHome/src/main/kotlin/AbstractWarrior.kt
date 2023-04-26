abstract class AbstractWarrior(  //абстрактный воин
    var maxHP: Double,      // максимальный уровень здоровья
    override val evasion: Int,   //шанс избежать попадания
    override var isKilled: Boolean = false,
    private val accuracy: Int,  //точность-вероятность попадания
    private val weapon: AbstractWeapon,//оружие
    val typeWeapon: String,  //тип оружия
    private var currentHP: Double = maxHP //текущий уровень здоровья
) : Warrior {


    override fun attack(warrior: Warrior) {
        var totalDamage = 0.0
        if (weapon.ammoMagazineIsEmpty) {//когда пустой магазин, перезаряжаем его, пропуск хода
            weapon.createAmmoMagazine()
            println("У меня нет патронов! Перезаряжаюсь. Пропускаю ход.")
        } else
            if (evasion.realizedChancer())  //нет попадания
                println("Я не попал в противника!")
            else {
                if (!evasion.realizedChancer() && accuracy.realizedChancer())  //есть попадания
                {
                    println("Я попал в противника!")
                    weapon.getAmmo().forEach() { totalDamage += it.currentDamage() }
                } else println("Я не попал  в противника!")
            }
        warrior.getDamage(totalDamage)

    }

    override fun getDamage(damage: Double) {
        currentHP -= damage
        if (damage > 0.0 && currentHP > 0.0) {
            println("Всего здоровья: ${"%.2f".format(currentHP)}. Получен урон: ${"%.2f".format(damage)}")
        }

        if (currentHP <= 0.0) {
            isKilled = true//убит

        }
    }

}


