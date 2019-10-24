package biz.pagodatech.foodtruckfinder.api.controller;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckReviewResource;
import biz.pagodatech.foodtruckfinder.api.service.FoodTruckService;
import biz.pagodatech.foodtruckfinder.api.transformer.FoodItemTransformer;
import biz.pagodatech.foodtruckfinder.api.transformer.FoodTruckTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Optional;

@RestController("/")
@Log4j2
@AllArgsConstructor
public class FoodTruckController {

    private FoodTruckService service;
    private FoodTruckTransformer transformer;
    private FoodItemTransformer foodItemTransformer;


    @GetMapping(path="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<FoodTruckResource>> getFoodTrucks(@RequestParam Optional<String> foodTruckName){
        log.debug("Getting food trucks!");
        Collection<FoodTruckEntity> entities = service.getFoodTrucks();
        return new  ResponseEntity(transformer.transform(entities), HttpStatus.OK);
    }
    @GetMapping(path="/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FoodTruckResource> searchFoodTrucks(@RequestParam(name="name", required = true) String foodTruckName){
        log.debug("Getting food trucks!");
        FoodTruckEntity entity = service.getFoodTruckByName(foodTruckName);
        return new  ResponseEntity(transformer.transform(entity), HttpStatus.OK);
    }

    @PostMapping(path="/food-trucks/:foodTruckName/reviews", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FoodTruckResource> addFoodTruckReview(
            @PathParam("foodTruckName") String foodTruckName,
            @AuthenticationPrincipal User user,
            @RequestBody @Valid FoodTruckReviewResource review
    ){
        log.debug("Creating a food truck review!");
        service.createFoodTruckReview(user, foodTruckName, review);
        FoodTruckEntity entity = service.getFoodTruckByName(foodTruckName);
        return new  ResponseEntity(transformer.transform(entity), HttpStatus.OK);
    }

    @PostMapping(path="/food-trucks/:foodTruckName/likes", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FoodTruckResource> addFoodTruckLike(
            @PathParam("foodTruckName") String foodTruckName,
            @AuthenticationPrincipal User user,
            @RequestBody @Valid FoodItemReviewResource review
    ){
        log.debug("Creating a food item like!");
        service.addFoodTruckLike(user, foodTruckName);
        FoodTruckEntity entity = service.getFoodTruckByName(foodTruckName);
        return new  ResponseEntity(transformer.transform(entity), HttpStatus.OK);
    }


    @PostMapping(path="/food-trucks/:foodTruckName/food-items/:foodItemId/reviews", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FoodItemResource> addFoodItemReview(
            @PathParam("foodTruckName") String foodTruckName,
            @PathParam("foodItemId") Long foodItemId,
            @AuthenticationPrincipal User user,
            @RequestBody @Valid FoodItemReviewResource review
    ){
        log.debug("Creating a food item review!");
        service.createFoodItemReview(user, foodTruckName, foodItemId, review);
        FoodItemEntity entity = service.getFoodItem(foodItemId);
        return new  ResponseEntity(foodItemTransformer.transform(entity), HttpStatus.OK);
    }

    @PostMapping(path="/food-trucks/:foodTruckName/food-items/:foodItemId/likes", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<FoodItemResource> addFoodItemLike(
            @PathParam("foodTruckName") String foodTruckName,
            @PathParam("foodItemId") Long foodItemId,
            @AuthenticationPrincipal User user,
            @RequestBody @Valid FoodItemReviewResource review
    ){
        log.debug("Creating a food item like!");
        service.addFoodItemLike(user, foodTruckName, foodItemId);
        FoodItemEntity entity = service.getFoodItem(foodItemId);
        return new  ResponseEntity(foodItemTransformer.transform(entity), HttpStatus.OK);
    }
}
