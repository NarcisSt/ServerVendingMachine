package server.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Exception exceptionFound() {
        return new Exception("Something went wrong :(. Try again.");
    }
}
