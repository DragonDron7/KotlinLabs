abstract class BankCard(var balance: Double) {

    abstract fun topUp(sum: Double)//пополняет карту на переданную сумму

    abstract fun pay(sum: Double): Boolean//списывает с карты необходимую сумму

    abstract fun getBalanceInfo(): String  //получить информацию о балансе

    abstract fun getInfoResources() //получить информацию о всех доступных средствах


}