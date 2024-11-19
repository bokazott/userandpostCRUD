package usersandpostsCRUD.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import usersandpostsCRUD.demo.exception.CityNotFoundException;
import usersandpostsCRUD.demo.exception.CountryNotFoundException;
import usersandpostsCRUD.demo.exception.PostNotFoundException;
import usersandpostsCRUD.demo.exception.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ResponseError> handleCountryNotFoundException(CountryNotFoundException ex){
        ResponseError responseError=new ResponseError(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<ResponseError> handleCityNotFoundException(CityNotFoundException ex){
        ResponseError responseError=new ResponseError(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(responseError,HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setMessage("Validation failed");
        response.setErrors(
                ex.getBindingResult().getFieldErrors().stream()
                        .map(error -> new ValidationError(
                                error.getField(),
                                error.getDefaultMessage(),
                                error.getRejectedValue()
                        ))
                        .collect(Collectors.toList())
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    static class ValidationErrorResponse {
        private String message;
        private List<ValidationError> errors;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<ValidationError> getErrors() {
            return errors;
        }

        public void setErrors(List<ValidationError> errors) {
            this.errors = errors;
        }
    }
    static class ValidationError {
        private String field;
        private String message;
        private Object rejectedValue;

        public ValidationError(String field, String message, Object rejectedValue) {
            this.field = field;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        public void setRejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
        }
    }


    static class ResponseError {
        private String message;
        private int statusCode;

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

