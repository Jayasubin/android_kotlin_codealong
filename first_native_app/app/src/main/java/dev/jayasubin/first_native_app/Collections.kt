package dev.jayasubin.first_native_app

fun main(){
    //val numbers:IntArray= intArrayOf(1,2,4)
    //val someArray:Array<Int> = arrayOf(3,5)

//    val newSet= setOf("ball","court")
//    newSet.toMutableSet()

//    val newMap= mapOf(1 to "one",2 to "two",4 to "four")
//    newMap.toSortedMap()

    val arrayList:ArrayList<Double> = arrayListOf()

    arrayList.addAll(arrayOf(2.4,1.5,3.5,3.2,2.5))
    println(arrayList)

println(getAvg(arrayList))
}

fun getAvg( arrayList:ArrayList<Double>):Double{
    var total=0.0
    for(value in arrayList){
        total+=value
    }

    return total/arrayList.size
}