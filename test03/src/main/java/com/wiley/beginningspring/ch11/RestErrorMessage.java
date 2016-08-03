package com.wiley.beginningspring.ch11;

import org.springframework.http.HttpStatus;

/**
 * Created by zjladmin on 2016/8/3.
 */
public class RestErrorMessage {
    private HttpStatus status;
    private int code;
    private String message;
    private String detailedMessage;
    private String exceptionMessage;
    public RestErrorMessage(HttpStatus status,int code,String message,String detailedMessage,String exceptionMessage){
        this.status=status;
        this.code=code;
        this.message=message;
        this.detailedMessage=detailedMessage;
        this.exceptionMessage=exceptionMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
