class Team(private var countWarrior: Int) {


    fun createTeam(): MutableList<AbstractWarrior> {
        var listSolders = mutableListOf<AbstractWarrior>()

        for (i in 1..countWarrior) {
            if (SuperSoldier.realizedChancer()) {
                listSolders.add(SuperSoldier())
            } else
                if (HeavyInfantry.realizedChancer()) {
                    listSolders.add(HeavyInfantry())
                } else
                    if (Sniper.realizedChancer()) {
                        listSolders.add(Sniper())
                    } else
                        if (Gunner.realizedChancer()) {
                            listSolders.add(Gunner())
                        } else listSolders.add(InfantrySoldier())
        }
        return listSolders
    }



    companion object Chance {
        //вероятность % создания война
        const val SuperSoldier = 5
        const val HeavyInfantry = 10
        const val Sniper = 20
        const val Gunner = 40
    }

}