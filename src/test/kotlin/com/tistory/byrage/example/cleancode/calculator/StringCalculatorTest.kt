package com.tistory.byrage.example.cleancode.calculator

import com.tistory.byrage.example.cleancode.calculator.Calculator.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    @DisplayName("계산")
    fun success() {
        assertThat(calculate("4 / 2 + 3 * 2 - 5")).isEqualTo(5)
        assertThat(calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    @DisplayName("알 수 없는 기호")
    fun unknownSymbol() {
        assertThatThrownBy { calculate("4 ^ 2") }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("입력 값이 null 또는 빈 문자열")
    fun nullOrEmptyInput() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}