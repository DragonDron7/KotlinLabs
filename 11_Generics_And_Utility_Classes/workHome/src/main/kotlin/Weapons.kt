import kotlin.random.Random
import kotlin.random.nextInt

object Weapons {//разные виды оружия

    fun createPistolet(): AbstractWeapon {
        return object : AbstractWeapon(
            maxAmmo = 12, fireType = FireType.SingleShot, ammoMagazine = Stack()
        ) {
            override fun creatingAmmo(): Ammo =
                Ammo.PISTOLET_BULLET //переопределяю метод для создания патрона под пистолет
        }
    }

    fun createGUN(): AbstractWeapon {
        return object : AbstractWeapon(
            maxAmmo = 10, fireType = FireType.SingleShot, ammoMagazine = Stack()
        ) {
            override fun creatingAmmo(): Ammo =
                Ammo.GUN_BULLET //переопределяю метод для создания патрона под ружьё
        }
    }

    fun createSNIPER(): AbstractWeapon {
        return object : AbstractWeapon(
            maxAmmo = 10,
            fireType = FireType.FiringBursts(2),//может стрелять сериями от 2-4 патронов
            ammoMagazine = Stack()
        ) {
            override fun creatingAmmo(): Ammo =
                Ammo.SNIPER_BULLET //переопределяю метод для создания патрона под винтовку
        }
    }

    fun createRPG(): AbstractWeapon {
        return object : AbstractWeapon(
            maxAmmo = 1, fireType = FireType.SingleShot, ammoMagazine = Stack()
        ) {
            override fun creatingAmmo(): Ammo =
                Ammo.RPG_AMMO //переопределяю метод для создания патрона под РПГ
        }
    }

}
