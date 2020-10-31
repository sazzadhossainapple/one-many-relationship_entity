package com.example.onetomany.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceDoseNotExistException extends Exception {
    public ResourceDoseNotExistException(String resource
    ) {
        super(resource + "dose not exists!");
    }
}
