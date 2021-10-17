package com.someday.somework.feign.model;

import lombok.Value;

@Value
public class GyphiLink {

    private String error;
    private String status;
    private Object data;

    public boolean isEmpty() {
        return data == null ? true : false;
    }

    public static class GyphiLinkBuilder {

        public static GyphiLink getGyphiLink(String error, String status) {
            return new GyphiLink(error, status, null);
        }
    }
}

