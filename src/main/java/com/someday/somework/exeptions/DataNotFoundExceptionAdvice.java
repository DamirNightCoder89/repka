package com.someday.somework.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DataNotFoundExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String rateNotFoundHandler(DataNotFoundException e, HttpServletResponse response) {
        response.setStatus(500);
        return e.getMessage().toString();
    }
}
