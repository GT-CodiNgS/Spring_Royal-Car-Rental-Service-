package lk.ijse.coursework.advisor;

import lk.ijse.coursework.exception.NotFoundException;
import lk.ijse.coursework.exception.ValidateException;
import lk.ijse.coursework.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Gayash Thasmika
 * @date:6/17/2021
 * @since : 0.0.1
 **/
@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity(new StandardResponse("500", "Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandardResponse("404", "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException e) {
        return new ResponseEntity(new StandardResponse("400", "Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
