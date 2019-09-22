package com.xavier.mservice.service.exception;

import org.springframework.http.HttpStatus;

public class ServiceExistException extends BusnessException {
    public ServiceExistException() {
        super("service-3", HttpStatus.BAD_REQUEST);
    }
}
