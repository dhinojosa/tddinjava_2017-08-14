package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PenaltyCalculatorTest {

    @Test
    public void testTodaysDateIsSameCheckoutDateAndAmountIsZero() {
        LocalDate todaysDate = LocalDate.of(2017, 2, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 2, 1);
        assertThat(PenaltyCalculator.calculate(todaysDate, checkoutDate, 0)).isEqualTo(0);
    }

    @Test
    public void testTodaysDateIsSameCheckoutDateAndAmountIsTen() {
        LocalDate todaysDate = LocalDate.of(2017, 2, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 2, 1);
        assertThat(PenaltyCalculator.calculate(todaysDate, checkoutDate, 10)).isEqualTo(0);
    }

    @Test
    public void testTodaysDateIsOneMonthAfterCheckoutDateAndAmountIsTen() {
        LocalDate todaysDate = LocalDate.of(2017, 3, 1);
        LocalDate checkoutDate = LocalDate.of(2017, 2, 1);
        assertThat(PenaltyCalculator.calculate(todaysDate, checkoutDate, 10)).isEqualTo(0);
    }

    @Test
    public void testTodaysDateIsOneMonthOneDayAfterCheckoutDateAndAmountIsTen() {
        LocalDate todaysDate = LocalDate.of(2017, 3, 2);
        LocalDate checkoutDate = LocalDate.of(2017, 2, 1);
        assertThat(PenaltyCalculator.calculate(todaysDate, checkoutDate, 10)).isEqualTo(10);
    }

    //We definitely need to do more...

}
