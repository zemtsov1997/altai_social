package ru.altai.social.service.exeption;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.altai.service.api.exeption.ErrorModel;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.*;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorModel error = new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String jsonObject = null;
        try {
            Map<String, Object[]> fieldErrors = new LinkedHashMap<>();
            ex.getBindingResult().getFieldErrors().stream().forEach(fieldError -> {
                if (!fieldErrors.containsKey(fieldError.getField())) {
                    fieldErrors.put(fieldError.getField(), new String[]{fieldError.getDefaultMessage()});
                } else {
                    Object[] arrayDefaultMessage = fieldErrors.get(fieldError.getField());

                    List<Object> listDefaultMessage = new LinkedList<>(Arrays.asList(arrayDefaultMessage));
                    listDefaultMessage.add(fieldError.getDefaultMessage());

                    fieldErrors.put(fieldError.getField(), listDefaultMessage.toArray());
                }
            });
            jsonObject = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(fieldErrors);
        } catch (JsonProcessingException e) {
            logger.error(e);
            return this.handleAllExceptions(e, request);
        }
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Validation Error", jsonObject);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // If the @Validated is failed
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }



}
