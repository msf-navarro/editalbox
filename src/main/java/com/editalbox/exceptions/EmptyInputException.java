package com.editalbox.exceptions;

public class EmptyInputException extends RuntimeException{
    String parameterName;

    public EmptyInputException (String parameterName) {
        super (String.format(
                "[BAD_REQUEST: parameter \"%s\" can not be empty]",
                parameterName
        ));
        //used in the RestControllerExceptionHandler
        this.parameterName = parameterName;
    }
}
