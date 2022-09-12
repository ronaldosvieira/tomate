package tech.tomate.api.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionToHttpStatusConverter {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException(NoSuchElementException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgument(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().build();
    }
}
