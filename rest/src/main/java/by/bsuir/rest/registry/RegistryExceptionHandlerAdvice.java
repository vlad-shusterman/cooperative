package by.bsuir.rest.registry;

import by.bsuir.core.exceptions.DataManipulateException;
import com.mongodb.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "by.bsuir.rest.registry")
public class RegistryExceptionHandlerAdvice {

    @ExceptionHandler
    public void handle(DataManipulateException e) {

    }

    @ExceptionHandler
    public void handle(DuplicateKeyException e) {

    }

}
