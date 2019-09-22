package com.xavier.mservice.service.exception;

import org.springframework.http.HttpStatus;

public class ServiceNotFoundExcetion extends BusnessException {
    public ServiceNotFoundExcetion() {
        super("service-4", HttpStatus.BAD_REQUEST);
    }
}
