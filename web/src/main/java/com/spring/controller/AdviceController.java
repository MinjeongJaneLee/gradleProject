package com.spring.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleError404(NoHandlerFoundException exception) {
        log.error("o: {}", exception);

        return "/error/404-not-found";
    }


    @ExceptionHandler(Exception.class)
    public String handle(Exception exception) {
        log.error("o: {}", exception);

        return "/error/500-internal-server-error";
    }
}
