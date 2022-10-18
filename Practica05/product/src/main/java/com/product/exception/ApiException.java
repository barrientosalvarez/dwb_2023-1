package com.product.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RunTimeException{
    
    private HttpStatus status;

    public ApiException(HttpStatus status, String message){
        super(message);
        this.status=status;
    }

    public HttpStaus getStatus(){
        return status;
    }

    public void setStatus(HttpStatus status){
        this.status=status;
    }

}
