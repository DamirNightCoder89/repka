package com.someday.somework.exeptions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@RestControllerAdvice
public class RateNotFoundExceptionAdvice {

//    @ResponseBody
//    @ExceptionHandler(FeignException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String rateNotFoundHandler(FeignException e, HttpServletResponse response) {
//        System.out.println("erooooooooooooooooooooooooooooooooooooooooooooooooooo.......................................!!!!!!!!!!!!!!!!!!!!");
//        response.setStatus(e.status());
//        return e.getMessage().toString();
//    }
}
