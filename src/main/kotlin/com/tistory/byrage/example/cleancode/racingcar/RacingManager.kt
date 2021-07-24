package com.tistory.byrage.example.cleancode.racingcar

class RacingManager(numberOfCars: Int, private val numberGenerator: NumberGenerator) {
    private val cars: MutableList<Car> = mutableListOf()

    init {
        for (i in 0 until numberOfCars) {
            cars.add(Car(i))
        }
    }

    fun race() {
        cars.forEach {
            val shouldMovePosition = numberGenerator.generate()
            it.race(shouldMovePosition)
        }
    }

    fun buildScore(): String {
        return with(StringBuilder()) {
            cars.map { car -> "${car.number}: ${convertSymbolToPosition(car.position)}" }
                .forEach { score -> append("$score\n") }
            toString()
        }
    }

    fun getCars(): List<Car> {
        return ArrayList(cars)
    }

    private fun convertSymbolToPosition(position: Int): String {
        val symbol = "-"
        return with(StringBuilder()) {
            for (i in 0 until position) {
                append(symbol)
            }
            toString()
        }
    }
}