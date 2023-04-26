enum class Ammo(//выды патронов
    var damage: Double,//урон
    private val chanceCriticalDamage: Int,//шанс критического урона
    private val coefficientCriticalDamage: Double = 1.1//коэфициент критического урона
) {
    PISTOLET_BULLET(15.0, 33),
    GUN_BULLET(20.0, 50, 1.3),
    SNIPER_BULLET(45.0, 63),
    RPG_AMMO(55.0, 78, 2.3);


        fun currentDamage():Double {
            if (chanceCriticalDamage.realizedChancer()) {

                println("Критический урон ${"%.2f".format(damage * coefficientCriticalDamage)}")
                return damage * coefficientCriticalDamage
            } else {
                println("Текущий урон ${"%.2f".format(damage)}")
                return damage

            }

        }
}





