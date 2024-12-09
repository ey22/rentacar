package eylul.rentacar.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
//This class handles specific exceptions thrown in the application

@ControllerAdvice
@RestController //Ensure responses are serialized as JSON
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class) //Captures exceptions of type IllegalArgumentException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage()); // Adds the exception message to the response
        return errorResponse;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "User not found"); // Adds a user-friendly error message
        errorResponse.put("message", ex.getMessage()); // Adds the exception's original message.
        return errorResponse;
    }
}
