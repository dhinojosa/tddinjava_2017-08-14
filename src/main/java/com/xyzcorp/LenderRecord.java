package com.xyzcorp;

import java.time.LocalDate;
import java.util.Objects;

public class LenderRecord {
    private final String name;
    private final String title;
    private final LocalDate checkoutDate;

    public LenderRecord(String name, String title, LocalDate checkoutDate) {
       this.name = name;
       this.title = title;
       this.checkoutDate = checkoutDate;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LenderRecord)) return false;
        LenderRecord other = (LenderRecord) obj;
        return Objects.equals(this.checkoutDate, other.checkoutDate) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.title, other.title);
    }

}
