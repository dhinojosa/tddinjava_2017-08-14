package com.xyzcorp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.stream.Stream;

public class LenderParser {
    private final String delimiter;

    public LenderParser(String delimiter) {
       this.delimiter = delimiter;
    }

    public LenderRecord parse(String string) {
        String[] args = string.split(delimiter);
        return new LenderRecord(args[0], args[1], LocalDate.parse(args[2]));
    }

    public Stream<LenderRecord> parse(Stream<String> stream) {
         return stream.map(s -> parse(s));
    }
}
