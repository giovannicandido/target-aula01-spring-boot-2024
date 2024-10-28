package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class AppControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handleException(RuntimeException ex) {
        log.error(ex.getMessage(), ex);
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        detail.setTitle("A problem happening we are looking into it");
        detail.setDetail("A problem happening we are looking into it");
        return detail;
    }

    @ExceptionHandler(EntityNotFoundInDatabaseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleException(EntityNotFoundInDatabaseException ex) {
        log.info(ex.getMessage(), ex);
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        detail.setDetail("%s not found in Database with id %s".formatted(ex.getEntityName(), ex.getEntityId()));
        detail.setTitle("Entity not found in Database");
        return detail;
    }
}
