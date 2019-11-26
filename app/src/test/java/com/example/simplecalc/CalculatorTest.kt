package com.example.simplecalc

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matchers.closeTo
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4



/**
 * Created by Olije Favour on 11/24/2019.
 * Copyright (c) 2019    All rights reserved.
 */


@RunWith(JUnit4::class)
class CalculatorTest {

    lateinit var mCalculator: Calculator
    @Before
    fun setUp() {

        mCalculator= Calculator()
    }

    @Test
    fun addTwoNumbers() {

        var result = mCalculator.add(2.0 ,2.5)

//        assertThat(result, is(equalTo(4.5)))
//        assertThat<Double>(result, `is`<Double>(equalTo<Double>(4.5)))
        assertThat(result, `is`(equalTo(4.5)))

    }

    @Test
    fun addTwoNumbersNegative() {
        val resultAdd = mCalculator.add(-1.0, 2.0)
        assertThat(resultAdd, `is`(equalTo(1.0)))
    }

    @Test
    fun addTwoNumbersFloats() {
        val resultAdd = mCalculator.add(1.111, 1.111)
        assertThat(resultAdd, `is`(closeTo(2.222, 0.01)))
    }

    @Test
    fun subTwoNumbers() {
        val resultSub = mCalculator.sub(1.0, 1.0)
        assertThat(resultSub, `is`(equalTo(0.0)))
    }

    @Test
    fun subWorksWithNegativeResult() {
        val resultSub = mCalculator.sub(1.0, 17.0)
        assertThat(resultSub, `is`(equalTo(-16.0)))
    }

    @Test
    fun mulTwoNumbers() {
        val resultMul = mCalculator.mul(32.0, 2.0)
        assertThat(resultMul, `is`(equalTo(64.0)))
    }

    @Test
    fun divTwoNumbers() {
        val resultDiv = mCalculator.div(32.0, 2.0)
        assertThat(resultDiv, `is`(equalTo(16.0)))
    }

    @Test
    fun divTwoNumbersZero() {
        val resultDiv = mCalculator.div(32.0, 0.0)
        assertThat(resultDiv, `is`(equalTo(java.lang.Double.POSITIVE_INFINITY)))
    }
}