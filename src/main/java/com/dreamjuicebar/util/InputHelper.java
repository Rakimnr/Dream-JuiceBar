package com.dreamjuicebar.util;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Central input utility for validation + smooth console UX.
 * Adds:
 * - readLine() allowing empty input (useful for "Press Enter")
 * - readMoney() using BigDecimal for proper billing
 */
public class InputHelper {
    private final Scanner sc;

    public InputHelper(Scanner sc) {
        this.sc = sc;
    }

    /** Reads a line (can be empty). */
    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /** Reads non-empty string. */
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

    /** Reads monetary amount safely. Examples: 450 or 450.00 */
    public BigDecimal readMoney(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                BigDecimal v = new BigDecimal(s);
                if (v.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.println("⚠ Amount must be > 0");
                    continue;
                }
                return v;
            } catch (Exception e) {
                System.out.println("⚠ Invalid amount. Example: 450 or 450.00");
            }
        }
    }

    public void pause() {
        readLine("Press Enter to continue...");
    }
}
