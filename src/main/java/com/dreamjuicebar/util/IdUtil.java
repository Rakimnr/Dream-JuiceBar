package com.dreamjuicebar.util;

/** Simple ID helper: J001, J002... */
public class IdUtil {
    public static String nextId(String prefix, int nextNumber) {
        return String.format("%s%03d", prefix.toUpperCase(), nextNumber);
    }
}
