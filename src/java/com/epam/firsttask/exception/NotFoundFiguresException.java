package com.epam.firsttask.exception;

public class NotFoundFiguresException extends Exception {
    public NotFoundFiguresException() {
    }

    public NotFoundFiguresException(String message) {
        super(message);
    }

    public NotFoundFiguresException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundFiguresException(Throwable cause) {
        super(cause);
    }
}
