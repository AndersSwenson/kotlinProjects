package com.example.lemonade

import androidx.compose.ui.res.stringResource

class LemonTree(var stage: Int = 1) {

    var randomCountDown: Int = (1..3).random()

    fun continueProgress(): Boolean {
        if(randomCountDown-- > 0) {
            return false;
        } else {
            randomCountDown = (1..3).random()
            return true
        }
    }

    fun updateStage(): Int {
        stage = when(stage) {
            1 -> 2
            2 -> {
                if(continueProgress()) {
                    3
                } else {
                    2
                }
            }
            3 -> 4
            else -> 1
        }
        return stage
    }

}