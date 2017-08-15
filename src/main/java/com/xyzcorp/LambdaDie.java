package com.xyzcorp;

import java.util.function.Supplier;

public class LambdaDie implements Die {
    public LambdaDie(Supplier<Integer> supplier) {
    }

    @Override
    public int getPips() {
        return 0;
    }

    public LambdaDie roll() {
        return null;
    }
}
