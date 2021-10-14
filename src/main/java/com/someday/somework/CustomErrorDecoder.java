package com.someday.somework;

import com.someday.somework.exeptions.RateNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (responseStatus.is5xxServerError()) {
            return new RateNotFoundException();
        } else if (responseStatus.is4xxClientError()) {
            return new RateNotFoundException();
        } else {
            return new Exception("Generic exception");
        }
    }
}
