package com.tistory.byrage.example.cleancode.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StubNumberGeneratorTest {
    @Test
    internal fun name() {
        val stubNumber = 1
        val stubNumberGenerator = StubNumberGenerator(stubNumber)
        val number = stubNumberGenerator.generate()

        assertThat(number).isEqualTo(stubNumber)
    }
}