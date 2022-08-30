package dev.jayasubin.first_native_app

fun main(){
    val driveAge: Byte = 18
    val oldAge: Byte = 75
    val deathAge: Byte = 125

    val yourAge: Byte = 25

    /*if(hisAge>=driveAge){
        print("You can drive legally")
    }*/

    when (yourAge) {
        in 0..driveAge -> print("You are a child")
        in driveAge..oldAge -> print("You can drive legally")
        in oldAge..deathAge -> print("You are too old to drive")
        else -> print("You don't exist")
    }
}