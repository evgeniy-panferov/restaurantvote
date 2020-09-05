package ru.restarauntvote.util.exception;

public class TimeIsOverException extends ApplicationException {
    public static final String TIME_IS_OVER_EXCEPTION = "exception.common.timeIsOver";

    public TimeIsOverException(String arg) {
        super(ErrorType.TIME_IS_OVER, TIME_IS_OVER_EXCEPTION, arg);
    }
}
