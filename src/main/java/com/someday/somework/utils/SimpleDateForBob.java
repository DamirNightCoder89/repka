package com.someday.somework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateForBob {

    private static final SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");

    private SimpleDateForBob() {
        throw new AssertionError();
    }

    public static SimpleDateFormat getSimpleDate() {
        return simpleDate;
    }

    public static String getCurrentDate() {
        return simpleDate.format(System.currentTimeMillis());
    }

    public static String getYsterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return simpleDate.format(cal.getTime());
    }
}
