package com.xyzcorp;

import java.util.Random;

public class JavaRandomDie implements Die {

    private final Random random;
    private final int pips;

    public JavaRandomDie(Random random) {
        this(random, 1);
    }
    
    public JavaRandomDie(Random random, int pips) {
    	    this.random = random;
        this.pips = pips;
    }

    @Override
    public int getPips() {
        return pips;
    }

    @Override
    public Die roll() {
        return new JavaRandomDie(random, random.nextInt(6) + 1);
    }
}
