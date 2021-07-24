package com.tistory.byrage.example.cleancode.racingcar

class StubNumberGenerator(private val stubNumber: Int) : NumberGenerator {
    override fun generate(): Int {
        return stubNumber
    }
}