package com.someday.somework.exeptions;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super("Could connect to dates, maybe your internet is turned off");
    }
}
