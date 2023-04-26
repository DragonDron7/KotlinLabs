fun main() {
    val firstName : String = "Andrey"
    val lastName: String = "Morozkin"
    var height: Double = 1.83
    val weight: Float = 60f
    var isChild: Boolean = height < 1.50 || weight < 40

    var info: String ="""
        <|> My mame is $firstName.
        <|> My surname $lastName.
        <|> My height  $height m.
        <|> My weight  $weight kg.
        
        <|> I'm a chaild? $isChild
        """ .trimMargin("<|> ")
    println(info)

    height=1.29
     isChild = height < 1.50 || weight < 40

     info ="""
     My mame is $firstName.
     My surname $lastName.
     My height  $height m.
     My weight  $weight kg.
        
     I'm a chaild? $isChild
        """
    println(info)



}