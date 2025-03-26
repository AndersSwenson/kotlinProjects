package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val expectedTotal = NumberFormat.getCurrencyInstance().format(12)
        val ttPair = calculateTipAndTotal(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, ttPair.first)
        assertEquals(expectedTotal, ttPair.second)
    }

}