package com.kpi.it01.team1.lab13.exceptions;

public class FacultyAlreadyExistsException extends Exception {
    public FacultyAlreadyExistsException() {
    }

    public FacultyAlreadyExistsException(String message) {
        super(message);
    }

    public FacultyAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public FacultyAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
