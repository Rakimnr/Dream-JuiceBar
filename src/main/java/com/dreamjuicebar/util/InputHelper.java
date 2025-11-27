package com.dreamjuicebar.util;

import java.util.Scanner;

/**
 * Centralized input utility to enforce validation and avoid Scanner newline bugs.
 * This becomes the “single source of truth” for console input.
 */
public class InputHelper {
    private final Scanner sc;

    public InputHelper(Scanner sc) {
        this.sc = sc;
    }

    public String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("⚠ Input cannot be empty. Try again.");
        }
    }

    public int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("⚠ Enter a number between " + min + " and " + max);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid number. Try again.");
            }
        }
    }

    public double readDouble(String prompt, double minExclusive) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v <= minExclusive) {
                    System.out.println("⚠ Must be > " + minExclusive);
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid number. Try again.");
            }
        }
    }
}
