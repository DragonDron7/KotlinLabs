class InfantrySoldier(_maxHP:Double =100.00) : AbstractWarrior( // Пехотинец

    maxHP = _maxHP,            // максимальный уровень здоровья
    evasion = 20,              //шанс избежать попадания
    accuracy = 45,             //точность-вероятность попадания
    weapon = Weapons.createPistolet(),  //оружие
    typeWeapon = "пистолет",
    currentHP=_maxHP
) {
    override fun attack(warrior: Warrior) {
        super.attack(warrior)
    }
}