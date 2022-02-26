package com.chongba.exception;

/**
 * Created by luMingLei
 */
public class TaskNotExistException extends  RuntimeException {


    private static final long serialVersionUID = 4571317516880121730L;

    public TaskNotExistException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    public TaskNotExistException(final Throwable cause) {
        super(cause);
    }
    
}
