class Sniper(_maxHP:Double =150.00) : AbstractWarrior( // Снайпер

    maxHP = _maxHP,            // максимальный уровень здоровья
    evasion = 80,              //шанс избежать попадания
    accuracy = 95,             //точность-вероятность попадания
    weapon = Weapons.createSNIPER(), //оружие
    typeWeapon = "снайперская винтовка",
    currentHP=_maxHP
) {
    override fun attack(warrior: Warrior) {
        super.attack(warrior)
    }
}