package com.tistory.byrage.example.cleancode.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @CsvSource(
        value = [
            "1 + 2 = 3",
            "33 + 22 = 55",
            "33 * 22 / 11 + 2 - 5 = 63",
        ], delimiter = '='
    )
    @ParameterizedTest
    internal fun completeExpression(input: String, answer: Int) {
        assertThat(stringCalculator.run(input)).isEqualTo(answer)
    }

    @NullAndEmptySource
    @ParameterizedTest
    internal fun nullOrEmpty(input: String?) {
        assertThatCode { stringCalculator.run(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("input is null or blank.")
    }
    
    @ValueSource(
        strings = [
            "1",
            "1 +",
        ]
    )
    @ParameterizedTest
    internal fun incompleteExpression(input: String) {
        assertThatCode { stringCalculator.run(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("input is incomplete.")
    }

    @ValueSource(
        strings = [
            "a + b",
            "1 + ",
        ]
    )
    @ParameterizedTest
    internal fun invalidNumber(input: String) {
        assertThatCode { stringCalculator.run(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("Invalid number.")
    }

    @ValueSource(
        strings = [
            "1 ! 2",
            "1 // 3",
            "1 2 3",
        ]
    )
    @ParameterizedTest
    internal fun invalidExpression(input: String) {
        assertThatCode { stringCalculator.run(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("Unsupported symbol")
    }
}
