package com.xyzcorp;

import java.util.Objects;

public class CaesarShift {
    public static final String THE_STRING_CANNOT_BE_NULL_MSG =
            "The string cannot be null";
    private final int shift;

    public CaesarShift(int shift) {
        this.shift = shift;
    }

    public String encode(String s) {
        Objects.requireNonNull(s, THE_STRING_CANNOT_BE_NULL_MSG);
        if (s.isEmpty()) return s;
		char c = s.charAt(0);
		if (!Character.isAlphabetic(c)) return s;
		char BEST_A = Character.isUpperCase(c) ? 'A' : 'a';
		return "" + (char)(BEST_A + (c + shift - BEST_A) % 26);
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
