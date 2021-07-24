package com.tistory.byrage.example.cleancode.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingManagerTest {

    @Test
    @DisplayName("초기상태 검증")
    internal fun init() {
        // given
        val numberOfCars = 3
        val stubNumber = 1

        val racingManager = RacingManager(numberOfCars, StubNumberGenerator(stubNumber))
        val cars = racingManager.getCars()

        // then
        assertThat(cars).hasSize(numberOfCars)
            .allMatch { car -> car.position == stubNumber }
    }

    @Test
    @DisplayName("점수 계산")
    internal fun race() {
        // given
        val racingManager = RacingManager(3, StubNumberGenerator(2))

        // when
        racingManager.race()

        // then
        val score = racingManager.buildScore()
        assertThat(score).isEqualTo(
            """0: ---
              |1: ---
              |2: ---
              |""".trimMargin()
        )
    }
}