package com.spring.utility.message;


import com.spring.utility.exception.ProjectException;


public interface CodeMessage {

    static final String MESSAGE_PATTERN = "^(ERROR|MSG|CODE)_(\\d+)_(.+)$";

    String getCode();

    String getMessage();

    String getMessage(Object... params);

    ProjectException toException();

    ProjectException toException(Object... params);

    ProjectException toException(Throwable cause);

    ProjectException toException(Throwable cause, Object... params);
}
