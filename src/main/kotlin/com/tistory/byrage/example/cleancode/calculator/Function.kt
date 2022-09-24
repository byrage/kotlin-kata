package com.tistory.byrage.example.cleancode.calculator

enum class Function(val symbol: String, val execute: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun from(symbol: String): Function {
            return values().firstOrNull { it.symbol == symbol } ?: throw IllegalArgumentException("Unsupported symbol[$symbol]")
        }
    }
}
