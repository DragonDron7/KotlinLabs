class HeavyInfantry( _maxHP:Double =130.00) : AbstractWarrior( // Тяжёлая пехота

    maxHP = _maxHP,            // максимальный уровень здоровья
    evasion = 40,              //шанс избежать попадания
    accuracy = 55,             //точность-вероятность попадания
    weapon = Weapons.createRPG(),  //оружие
    typeWeapon = "РПГ",
    currentHP=_maxHP
) {
    override fun attack(warrior: Warrior) {
        super.attack(warrior)
    }
}