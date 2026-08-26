package dev.juanim.movies_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice /* La clase vigilará todos los controladores, y se encargará de sus excepciones */
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class) /* Indica que el método se activa cuando, en concreto, se lance MovieNotFound */
    public ResponseEntity<Map<String, Object>> handleMovieNotFound(MovieNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", 404);
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        /* El ResponseEntity permite que edite - controle - todo lo relativo a la respuesta HTTP
        como código de estado o body */
    }
    
}
