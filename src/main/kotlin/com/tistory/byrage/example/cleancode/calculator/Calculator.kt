package com.tistory.byrage.example.cleancode.calculator

object Calculator {
    private const val delimiter = " "

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        val elements = input.split(delimiter)
        var result = elements[0].toInt()
        for (index in 1 until elements.size step 2) {
            val operator = parseOperator(elements[index])
            val operand = elements[index + 1].toInt()
            result = calculate(result, operand, operator)
        }
        return result
    }

    private fun parseOperator(element: String): Operator {
        return Operator.from(element)
    }

    private fun calculate(result: Int, operand: Int, operator: Operator): Int {
        return operator.calculateFunction(result, operand)
    }
}

enum class Operator(val symbol: String, val calculateFunction: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun from(symbol: String): Operator {
            return values().firstOrNull { it.symbol == symbol } ?: throw IllegalArgumentException()
        }
    }
}
