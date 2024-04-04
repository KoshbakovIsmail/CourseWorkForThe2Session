package com.WorkCourse.demoCourseWorkForThe2Session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionLimitationException extends RuntimeException {
    public QuestionLimitationException(String message) {
        super(message);
    }
}
