package com.hackaton.ezmilk.exception;

import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CommonExceptionResponse> handleException(Exception ex) {


        final CommonExceptionResponse respostaException = new CommonExceptionResponse(EnumDomainException.NULL_POINTER_EXCEPTION.getMessage());
        respostaException.setMessage(respostaException.getMessage());

        return exception(respostaException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
        return exception(ex.getResponseBodyAsString());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<String> handleHttpServerErrorException(HttpServerErrorException ex) {
        return exception(ex.getResponseBodyAsString());
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<CommonExceptionResponse> handleFcRuntimeException(DomainException ex) {
        return exception(ex);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<CommonExceptionResponse> handleSmartRuntimeExceptionA(DataException ex) {
        return exception(ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<CommonExceptionResponse> exception(Throwable e) {
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new CommonExceptionResponse(e.getMessage()));
    }

    private ResponseEntity<String> exception(String e) {
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(e);
    }

    private ResponseEntity<CommonExceptionResponse> exception(Throwable e, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new CommonExceptionResponse(e.getMessage()));
    }

    private ResponseEntity<CommonExceptionResponse> exception(CommonExceptionResponse respostaError, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(respostaError);
    }

}
