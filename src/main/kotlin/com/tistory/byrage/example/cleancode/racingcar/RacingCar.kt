package com.tistory.byrage.example.cleancode.racingcar

private fun readInt() = readLine()?.toInt() ?: throw IllegalArgumentException("Input must be integer type")

fun main(args: Array<String>) {
    println("자동차 대수는 몇 대 인가요?")
    val numberOfCars = readInt()
    println("시도할 회수는 몇 회 인가요?")
    val numberOfRounds = readInt()

    val racingManager = RacingManager(numberOfCars, RandomNumberGenerator())

    println()
    println("실행결과")

    for (round in 1..numberOfRounds) {
        racingManager.race()
        println(racingManager.buildScore())
    }
}