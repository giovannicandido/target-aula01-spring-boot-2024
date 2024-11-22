package br.com.eadtt.aula01.controller;

import br.com.eadtt.aula01.model.exceptions.EntityNotFoundInDatabaseException;
import br.com.eadtt.aula01.model.exceptions.PaymentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.*;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

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

    @ExceptionHandler(PaymentNotFoundException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ProblemDetail handleException(PaymentNotFoundException ex) {
        log.info(ex.getMessage(), ex);
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.PRECONDITION_FAILED);
        detail.setTitle("Payment not found");
        detail.setDetail(String.format("Cannot find payment for atendimento %s for client %s", ex.getAtendimentoId(), ex.getClientId()));
        return detail;
    }

    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        detail.setTitle("Invalid Request");
        detail.setDetail(ex.getMessage());
        List<String> validationMessages = ex.getAllErrors().stream().map(MessageSourceResolvable::getDefaultMessage).toList();
        detail.setProperty("messages", validationMessages);
        return ResponseEntity.badRequest().body(detail);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        detail.setTitle("Invalid Request");
        detail.setDetail("Invalid request");
        List<String> validationMessages = ex.getAllErrors().stream().map(objectError -> {

            if(objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                return fieldError.getField() + ": " + fieldError.getDefaultMessage();
            }

            return objectError.getDefaultMessage();

        }).toList();
        detail.setProperty("messages", validationMessages);
        return ResponseEntity.badRequest().body(detail);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ProblemDetail handleException(AuthorizationDeniedException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        detail.setTitle("Authorization Denied");
        return detail;
    }


}
