class Gunner( _maxHP:Double = 80.00) : AbstractWarrior( // Стрелок-пулемётчик

    maxHP = _maxHP,            // максимальный уровень здоровья
    evasion = 50,              //шанс избежать попадания
    accuracy = 50,             //точность-вероятность попадания
    weapon = Weapons.createGUN(),  //оружие
    typeWeapon = "ружьё",
    currentHP=_maxHP
) {
    override fun attack(warrior: Warrior) {
        super.attack(warrior)
    }
}