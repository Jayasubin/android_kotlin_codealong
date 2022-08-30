package dev.jayasubin.first_native_app

fun main() {
    val phone = Phone("generic", "0001", 0)
    phone.communicate()

    val nokia220 = GSMPhone("nokia", "220", 3500, 2)
    nokia220.communicate()

    val note5p = SmartPhone("redmi", "note5Pro", 16000, 6.25f, 13)
    note5p.communicate()
}

open class Phone(brand: String, model: String, price: Int) {
    init {
        println("Phone created with brand: $brand, model:$model and it costs Rs.$price")
    }

    open fun communicate() {
        println("Now I can communicate")
    }
}

class GSMPhone(brand: String, model: String, price: Int, private var simCount: Int) :
    Phone(brand, model, price) {
    override fun communicate() {
        println("I can communicate voice through $simCount sims")
    }
}

class SmartPhone(
    brand: String,
    model: String,
    price: Int,
    private var displaySize: Float,
    private var cameraMP: Int
) :
    Phone(brand, model, price) {
    override fun communicate() {
        println("I can communicate video on $displaySize inch display through $cameraMP MP camera")
    }
}