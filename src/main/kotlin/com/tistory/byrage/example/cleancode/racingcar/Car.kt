package com.tistory.byrage.example.cleancode.racingcar

class Car(val number: Int) {
    var position: Int = 1

    fun race(movePosition: Int) {
        position += movePosition
    }
}