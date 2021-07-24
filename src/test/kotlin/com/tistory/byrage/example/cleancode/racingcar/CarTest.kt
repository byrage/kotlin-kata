package com.tistory.byrage.example.cleancode.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    @DisplayName("자동차 생성시 초기 포지션 검증")
    internal fun init() {
        val car = Car(0)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    @DisplayName("race 호출 시 movePosition 만큼 이동한다")
    internal fun race() {
        val car = Car(0)
        car.race(10)
        assertThat(car.position).isEqualTo(11)
    }
}