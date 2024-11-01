package usersandpostsCRUD.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import usersandpostsCRUD.demo.exception.CityNotFoundException;
import usersandpostsCRUD.demo.exception.CountryNotFoundException;
import usersandpostsCRUD.demo.exception.PostNotFoundException;
import usersandpostsCRUD.demo.exception.UserNotFoundException;

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

