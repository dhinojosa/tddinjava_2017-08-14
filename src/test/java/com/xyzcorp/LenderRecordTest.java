package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LenderRecordTest {

    @Test
    public void testSimpleConstructionOfALenderRecordImmutableWithName() {

        LenderRecord lenderRecord = new LenderRecord("Ann Robinson", "2001: A Space Odyssey",
                                                      LocalDate.of(2017, 4, 10));
        assertThat(lenderRecord.getName()).isEqualTo("Ann Robinson");
        assertThat(lenderRecord.getTitle()).isEqualTo("2001: A Space Odyssey");
        assertThat(lenderRecord.getCheckoutDate()).isEqualTo(LocalDate.of(2017, 4, 10));
    }

    @Test
    public void testEqualityGivenTwoEqualObjects() {
        LenderRecord lenderRecord1 = new LenderRecord("Ann Robinson", "2001: A Space Odyssey",
                LocalDate.of(2017, 4, 10));
        LenderRecord lenderRecord2 = new LenderRecord("Ann Robinson", "2001: A Space Odyssey",
                LocalDate.of(2017, 4, 10));

        assertThat(lenderRecord1).isEqualTo(lenderRecord2);
    }


    @Test
    public void testEqualityGivenTwoNonEqualObjects() {
        LenderRecord lenderRecord1 = new LenderRecord("Anne Robinson", "2001: A Space Odyssey",
                LocalDate.of(2017, 4, 10));
        LenderRecord lenderRecord2 = new LenderRecord("Ann Robinson", "2001: A Space Odyssey",
                LocalDate.of(2017, 4, 10));

        assertThat(lenderRecord1).isNotEqualTo(lenderRecord2);
    }

    @Test
    public void testEqualityGivenTwoObjectsNotSameType() {
        LenderRecord lenderRecord1 = new LenderRecord("Anne Robinson", "2001: A Space Odyssey",
                LocalDate.of(2017, 4, 10));

        assertThat(lenderRecord1).isNotEqualTo(new Integer(50));
    }

    //We are not done
    // 1. nulls firstName title, and date
    // 2. firstName is blank

    //Keep going

}
