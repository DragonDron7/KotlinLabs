sealed class FireType { //тип выстрела
    object SingleShot : FireType()//одиночные
    data class FiringBursts(val queueSize: Int) : FireType()//очередь
}
