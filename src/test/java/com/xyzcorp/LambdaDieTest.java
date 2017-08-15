package com.xyzcorp;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaDieTest {

    @Test
    public void testRollOf4() throws Exception {
        LambdaDie lambdaDie = new LambdaDie(() -> 4);
        assertThat(lambdaDie.roll().getPips()).isEqualTo(4);
    }

    @Test
    public void testIntegration() throws Exception {
        Random random = new Random();
        LambdaDie lambdaDie = new LambdaDie(() -> random.nextInt(6) + 1);
        assertThat(lambdaDie.roll().getPips()).isEqualTo(4);
    }
}
