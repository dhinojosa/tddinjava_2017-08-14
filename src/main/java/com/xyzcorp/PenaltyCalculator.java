package com.xyzcorp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PenaltyCalculator {
    public static int calculate(LocalDate todaysDate, LocalDate checkoutDate, int amount) {
        long between = ChronoUnit.MONTHS.between(checkoutDate.plusDays(1), todaysDate);
        return (int)(between * amount);
    }
}
