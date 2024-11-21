package usersandpostsCRUD.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseError> handleUserNotFoundException(UserNotFoundException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ResponseError> handlePostNotFoundException(PostNotFoundException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ResponseError> handleCountryNotFoundException(CountryNotFoundException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ResponseError> handleCityNotFoundException(CityNotFoundException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateCityException.class)
    public ResponseEntity<ResponseError> handleDuplicateCityException(DuplicateCityException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateCountryException.class)
    public ResponseEntity<ResponseError> handleDuplicateCountryException(DuplicateCountryException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCityDataException.class)
    public ResponseEntity<ResponseError> handleInvalidCityDataException(InvalidCityDataException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCountryDataException.class)
    public ResponseEntity<ResponseError> handleInvalidCountryDataException(InvalidCountryDataException ex) {
        ResponseError responseError = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getFieldErrors();

        ResponseError responseError = new ResponseError();
        responseError.setStatusCode(HttpStatus.BAD_REQUEST.value());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fields that are not fulfilling the requirements are:");
        stringBuilder.append("\n");


        fieldErrors.forEach(fieldError -> {
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(" with message ");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append("\n");

        });

        responseError.setMessage(stringBuilder.toString());

        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }

    static class ResponseError {
        private String message;
        private int statusCode;

        public ResponseError() {

        }

        public ResponseError(String message, int statusCode) {
            this.message = message;
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }
}

