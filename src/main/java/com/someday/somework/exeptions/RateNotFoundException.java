package com.someday.somework.exeptions;

public class RateNotFoundException extends RuntimeException {

    public RateNotFoundException() {
        super("Could tetch rate dates");
    }
}
