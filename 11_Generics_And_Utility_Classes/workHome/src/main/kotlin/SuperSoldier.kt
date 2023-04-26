class SuperSoldier(_maxHP:Double =300.00) : AbstractWarrior(//супер солдат

    maxHP = _maxHP,            // максимальный уровень здоровья
    evasion = 80,              //шанс избежать попадания
    accuracy = 75,             //точность-вероятность попадания
    weapon = Weapons.createPistolet() + Weapons.createGUN() + Weapons.createRPG(), //оружие
    typeWeapon = "пистолет, ружьё, РПГ",
    currentHP=_maxHP
) {
    override fun attack(warrior: Warrior) {
        super.attack(warrior)
    }

}