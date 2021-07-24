package com.tistory.byrage.example.cleancode.racingcar

const val defaultRandomBound = 4

class RandomNumberGenerator(private val randomBound: Int = defaultRandomBound) : NumberGenerator {
    override fun generate(): Int {
        return (0..randomBound).random()
    }
}