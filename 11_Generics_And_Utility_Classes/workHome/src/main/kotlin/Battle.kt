class Battle(
    private val team1Count: Int,    //кол-во войнов в 1-й команде
    private val team2Count: Int     //кол-во войнов во 2-й команде
) {
    private var battleIsOver: Boolean = false

    private val team1 = Team(team1Count).createTeam()
    private val team2 = Team(team2Count).createTeam()


    fun progress() {
        BattleState.Progress().getBattleState(team1, team2)//информация о войнах: войн, его оружие и здоровье

        while (!battleIsOver) {
            battleStep()
        }
        println("Игра закончена!!!")
        println("\n Результат:")
        BattleState.Progress().getBattleState(team1, team2)
    }


    private fun battleStep() {//итерация битвы, ничья по такому алгоритму не подразумевается
        var i = 0
        var j = 0


        println(BattleState.AttackTeam1.mess)
        team1[i].attack(team2[j])
        if (team2[j].isKilled) {
            team2.remove(team2[j])
            println("✝ Игрок команды 2 УБИТ! ✝")
            if (team2.isEmpty()) {
                battleIsOver = true
                println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
                println(BattleState.Win1.mess)
                println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
            } else {

                println(BattleState.AttackTeam2.mess)//Атакует следующей игрок 2-й команды
                ++j
            }
        } else {

            println(BattleState.AttackTeam2.mess)
            team2[j].attack(team1[i])
            if (team1[i].isKilled) {
                team1.remove(team1[i])
                println("✝ Игрок команды 1 УБИТ! ✝ ")
                if (team1.isEmpty()) {
                    battleIsOver = true
                    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
                    println(BattleState.Win2.mess)
                    println(" ⟹ ⟺⟺⟺⟺⟺⟺⟺⟺⟺ ⟸")
                } else {
                    println(BattleState.AttackTeam1.mess)//Атакует следующей игрок первой команд

                    ++i
                }
            }
        }


    }
}





