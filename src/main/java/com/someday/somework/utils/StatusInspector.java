package com.someday.somework.utils;

public abstract class StatusInspector {

    public static String checkStatus(Integer status) {
        if (status >= 400 && status <= 499) {
            return "Bad request or possibly incorrect access settings";
        } else if((status >= 500 && status <= 599)) {
            return "Server is temporarily unavailable";
        } else {
            return "Сheck your internet connection or the server is temporarily unavailable";
        }

    }
}
