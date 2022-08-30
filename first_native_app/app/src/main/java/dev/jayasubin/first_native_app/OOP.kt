package dev.jayasubin.first_native_app

fun main(){
    val m1 = MobilePhone("Samsung","Note10", "Android 12")
//    val m2 = MobilePhone("Redmi","Note12", "MIUI 12")
//    val m3 = MobilePhone("Apple","Iphone 12", "IOS 14")

    m1.chargeBy(60)
    m1.chargeBy(60)
}

class MobilePhone (brand:String, model:String, osName:String){
    private var chargeLevel:Int = 0

    init{
        println("Initialised $brand $model with $osName OS")
    }

    fun chargeBy(increment:Int){
        println("Level before charging : $chargeLevel")

        chargeLevel+=increment
        if(chargeLevel>100) chargeLevel=100

        println("After charging : $chargeLevel")
    }

}

class SmartPhone(brand: String,model: String,osName: String) :MobilePhone(){
}