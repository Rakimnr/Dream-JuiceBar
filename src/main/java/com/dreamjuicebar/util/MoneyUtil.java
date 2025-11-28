package com.dreamjuicebar.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/** Money formatting helper for receipts/menu display. */
public class MoneyUtil {
    private static final DecimalFormat DF = new DecimalFormat("#,##0.00");

    public static String formatLKR(BigDecimal amount) {
        return "LKR " + DF.format(amount);
    }
}
