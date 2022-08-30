package dev.jayasubin.first_native_app

/*
    for
    for-in

    while
    do-while

    break
    continue
 */

fun main(){
   for(count in 0..10000){
       if(count==9001) println("IT'S OVER 9000!!!")
   }

    var humidityLevel=80
    var humidity="humid"

    while(humidity=="humid"){
        humidityLevel-=5
        println("Humidity reduced by 5")

        if(humidityLevel<=60) {
            humidity = "comfy"
            println("It's $humidity now!")
        }

    }
}