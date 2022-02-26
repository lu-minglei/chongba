package com.chongba.exception;

/**
 * Created by luMingLei
 */
public class ScheduleSystemException extends RuntimeException {

    private static final long serialVersionUID = -3138108380887385059L;

    public ScheduleSystemException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    public ScheduleSystemException(final Throwable cause) {
        super(cause);
    }
    
    
}
