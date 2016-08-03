package com.wiley.beginningspring.ch11;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by zjladmin on 2016/8/3.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleInvalidRequest(RestException e, ServletWebRequest request){
        RestErrorMessage error=new RestErrorMessage(
                HttpStatus.valueOf("OK"), //request.getResponse().getStatus()),
                        e.getCode(),
                        e.getMessage(),
                        e.getDetailedMessage(),
                        e.toString());
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(e,error,headers,HttpStatus.OK,request);
    }
}
