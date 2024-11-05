package com.example.Blogify.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String filedName, long fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName, filedName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = filedName;
        this.fieldValue = fieldValue;
    }
}
