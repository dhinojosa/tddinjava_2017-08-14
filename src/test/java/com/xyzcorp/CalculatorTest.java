package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddTwoNumbers() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(calculator.add(4, 4), 8);
    }

    @Test
    public void testAddTwoDifferentNumbers() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(calculator.add(4, 10), 14);
    }
}
