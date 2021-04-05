package dev.bearded.apigesthor.exception;

import ch.qos.logback.core.db.dialect.SybaseSqlAnywhereDialect;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.awt.*;

@ControllerAdvice
public class ContratoControllerException extends ResponseEntityExceptionHandler {

    /*@Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleBindException(ex, headers, status, request);
    }*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNumeroContratoJaExistenteException(Exception exception, WebRequest request){
        System.out.println(request.getParameterNames());
        return ResponseEntity.badRequest().body("Contrato com numero xxxxx já cadastrado");
    }
}
