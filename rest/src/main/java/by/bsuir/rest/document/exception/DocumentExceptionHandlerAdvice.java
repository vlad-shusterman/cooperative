package by.bsuir.rest.document.exception;

import by.bsuir.document.exception.DocumentGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DocumentExceptionHandlerAdvice {

    @ExceptionHandler(DocumentGenerationException.class)
    public ResponseEntity<Void> handleDocGenException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
