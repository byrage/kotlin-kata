package com.tistory.byrage.example.cleancode.calculator

object Validator {

    fun validateNumber(number: String) {
        try {
            number.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid number. [$number]", e)
        }
    }
}
