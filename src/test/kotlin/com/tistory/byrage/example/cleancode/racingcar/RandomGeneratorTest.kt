package com.tistory.byrage.example.cleancode.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomGeneratorTest {

    @Test
    internal fun generate() {
        val randomBound = 1
        val randomNumberGenerator = RandomNumberGenerator(randomBound)

        for (i in 0 until 10) {
            val number = randomNumberGenerator.generate()
            assertThat(number).isBetween(0, randomBound)
        }
    }
}