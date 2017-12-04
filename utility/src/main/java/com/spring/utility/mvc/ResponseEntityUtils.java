package com.spring.utility.mvc;


import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@UtilityClass
@Slf4j
public class ResponseEntityUtils {

    public <T> ResponseEntity<T> internalServerError(T body) {
        log.warn("response message: {}", body);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }


    public <T> ResponseEntity<T> unprocessableEntity(T body) {
        log.warn("response message: {}", body);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(body);
    }


    public <T> ResponseEntity<T> badRequest(T body) {
        log.warn("response message: {}", body);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


    public <T> ResponseEntity<T> ok(T body) {
        log.debug("response message: {}", body);

        return ResponseEntity.ok(body);
    }
}
