interface Hero {
    fun damage():Int
    fun weapon():String
}

class RockMan: Hero {
    override fun damage():Int = 1
    override fun weapon():String = "rock buster"
}

abstract class HeroWeaponDecorator(private val hero:Hero):Hero by hero

class AirManWeaponDecorator(private val hero: Hero): HeroWeaponDecorator(hero){
    override fun weapon():String = "air buster"
    override fun damage():Int = 3
}

class FireManWeaponDecorator(private val hero: Hero, private val isMaxPower:Boolean):HeroWeaponDecorator(hero){
    override fun weapon():String = "fireball"
    override fun damage(): Int = if(isMaxPower) 5 else 4
}

fun main(){
    val rockMan = RockMan()
    println("RockMan has ${rockMan.weapon()} and damage is ${rockMan.damage()}.")

    val rockManWithAirManWeapon = AirManWeaponDecorator(rockMan)
    println("RockMan has ${rockManWithAirManWeapon.weapon()} and damage is ${rockManWithAirManWeapon.damage()}.")

    val rockManWithFireManWeapon = FireManWeaponDecorator(rockMan, true)
    println("RockMan has ${rockManWithFireManWeapon.weapon()} and damage is ${rockManWithFireManWeapon.damage()}.")
}
//RockMan has rock buster and damage is 1.
//RockMan has air buster and damage is 3.
//RockMan has fireball and damage is 5.