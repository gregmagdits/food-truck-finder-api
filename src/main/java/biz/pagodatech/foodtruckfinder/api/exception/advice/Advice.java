package biz.pagodatech.foodtruckfinder.api.exception.advice;

import biz.pagodatech.foodtruckfinder.api.exception.AppUserNotFoundException;
import biz.pagodatech.foodtruckfinder.api.exception.FoodItemNotFoundException;
import biz.pagodatech.foodtruckfinder.api.exception.FoodTruckNotFoundException;
import biz.pagodatech.foodtruckfinder.api.exception.InvalidOrExpiredJWTToken;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@ControllerAdvice
@Log4j2
public class Advice {
    @Qualifier("errors")
    private ResourceBundle errors;

    @ExceptionHandler(value = FoodTruckNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(FoodTruckNotFoundException e) {
        String message = MessageFormat.format(errors.getString("foodtruck.notfound"), e.getFoodTruckName());
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = FoodItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(FoodItemNotFoundException e) {
        String message = MessageFormat.format(errors.getString("fooditem.notfound"), e.getFoodItemId());
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = AppUserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(AppUserNotFoundException e) {
        String message = MessageFormat.format(errors.getString("appuser.notfound"), e.getUsername());
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.NOT_FOUND);
    }
    //InvalidOrExpiredJWTToken
    @ExceptionHandler(value = InvalidOrExpiredJWTToken.class)
    public ResponseEntity<ErrorResponse> handle(InvalidOrExpiredJWTToken e) {
        String message = errors.getString("jwt.invalid");
        return new ResponseEntity<>(new ErrorResponse(message), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
