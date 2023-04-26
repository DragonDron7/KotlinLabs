sealed class BattleState() {
    val mess: String
        get() = when (this) {
            Win1 -> "\t Команда 1 Победила!"
            Win2 -> "\t Команда 2 Победила!"
            Draw -> "\t Ничья"
            AttackTeam1->"Игрок команды 1 атакует:"
            AttackTeam2->"Игрок команды 2 атакует:"
            else -> {
                ""
            }
        }

    object Draw : BattleState()
    object Win1 : BattleState()
    object Win2 : BattleState()
    object AttackTeam1 : BattleState()
    object AttackTeam2 : BattleState()
    class Progress() : BattleState() {


        fun getBattleState(team1: MutableList<AbstractWarrior>, team2: MutableList<AbstractWarrior>) {
            var i: Int = 1

            println("✪ Команда 1:")
            team1.forEach { it ->
                println(
                    "${i++}: Воин  \"${it::class.simpleName}\",  ➤ здоровье: ${it.maxHP}, ➤ оружие: ${it.typeWeapon}"
                )
            }
            println("Общее здоровье воинов: ${team1.sumOf { it.maxHP }}")
            i = 1

            println("✠ Команда 2:")
            team2.forEach { it ->
                println(
                    "${i++}: Воин  \"${it::class.simpleName}\",  ➤ здоровье: ${it.maxHP}, ➤ оружие: ${it.typeWeapon}"
                )
            }
            println("Общее здоровье воинов: ${team2.sumOf { it.maxHP }}")
        }
    }


}
