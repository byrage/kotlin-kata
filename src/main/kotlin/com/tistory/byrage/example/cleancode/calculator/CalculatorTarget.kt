package com.tistory.byrage.example.cleancode.calculator

class CalculatorTarget(
    val a: Int,
    val function: Function,
    val b: Int,
) {
    companion object {
        fun of(a: String, function: String, b: String): CalculatorTarget {
            Validator.validateNumber(a)
            Validator.validateNumber(b)
            return CalculatorTarget(
                a = a.toInt(),
                function = Function.from(function),
                b = b.toInt()
            )
        }
    }

    fun execute(): Int {
        return function.execute(a, b)
    }
}
