package com.editalbox.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    Long resourceId;

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(String.format(
                "[NOT_FOUND: %s not found with id \"%d\"]",
                resourceName,
                resourceId
                )
        );
        //used in the RestControllerExceptionHandler
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }
}
