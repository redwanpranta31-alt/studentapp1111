package com.luv2code.studentapp.exceptionhandler;

public class InvalidDepartmentException extends RuntimeException {
    public InvalidDepartmentException(String message) {
        super(message);
    }

    public InvalidDepartmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDepartmentException(Throwable cause) {
        super(cause);
    }
}
