interface Warrior {
    val evasion: Int
    var isKilled:Boolean
    fun attack(warrior:Warrior)//атаковать, принимаем противника(Warrior)
    fun getDamage(damage: Double)//понести урон

}