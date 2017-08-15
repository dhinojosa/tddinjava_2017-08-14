package com.xyzcorp;

import java.util.Objects;
import java.util.stream.Collectors;

public class CaesarShift {
    public static final String THE_STRING_CANNOT_BE_NULL_MSG =
            "The string cannot be null";
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    private char encodeChar(char c, int actualShift) {
        if (!Character.isAlphabetic(c)) return c;
        char BEST_A = Character.isUpperCase(c) ? 'A' : 'a';
        return (char)((c + actualShift % 26 + 26 - BEST_A) % 26 + BEST_A);
    }

    private String encodeString(String s, int actualShift) {
        Objects.requireNonNull(s, THE_STRING_CANNOT_BE_NULL_MSG);
        if (s.isEmpty()) return s;
        return s.chars()
                .boxed()
                .map((Integer i) -> "" + encodeChar((char) i.intValue(), actualShift))
                .collect(Collectors.joining());
    }

    public String encode(String s) {
        return encodeString(s, shift);
    }

    public String decode(String s) {
        return encodeString(s, -shift);
    }

//    public String encodeKeith(String s) {
//        if (s.isEmpty()) return s;
//        char shifted = (char)(s.charAt(0) + shift);
//        if (shifted > 'z') shifted %= 26;
//        return "" + shifted;
//    }
//
//    public String encodeTanzeem(String input) {
//        if (input.isEmpty()) return input;
//        int intValue = (input.charAt(0) + shift);
//        if (intValue > 122) {
//            return "" + (char) (intValue - 122 + 96);
//        }
//        return "" + (char) intValue;
//    }
}
