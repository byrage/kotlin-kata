package com.tistory.byrage.example.cleancode.calculator

class StringCalculator {

    fun run(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("input is null or blank. input=$input")
        }

        val eachInput = input.split(" ")
        if (eachInput.size <= 2) {
            throw IllegalArgumentException("input is incomplete. input=$input")
        }

        val target = CalculatorTarget.of(
            a = eachInput[0],
            function = eachInput[1],
            b = eachInput[2]
        )
        var result = target.execute()

        var cursor = 3
        while (cursor < eachInput.size) {
            result = CalculatorTarget.of(
                a = result.toString(),
                function = eachInput[cursor],
                b = eachInput[cursor + 1]
            ).execute()
            cursor += 2
        }
        return result
    }
}
