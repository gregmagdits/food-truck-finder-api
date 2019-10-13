package biz.pagodatech.foodtruckfinder.api.controller;

import biz.pagodatech.foodtruckfinder.api.service.FoodTruckService;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckResource;
import biz.pagodatech.foodtruckfinder.api.transformer.FoodTruckTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@Log4j2
@AllArgsConstructor
public class FoodTruckController {

    private FoodTruckService service;
    private FoodTruckTransformer transformer;


    @GetMapping(path="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FoodTruckResource>> getFoodTrucks(){
        log.debug("Getting food trucks");
        List<FoodTruckEntity> entities = service.getFoodTrucks();
        return new  ResponseEntity(transformer.transform(entities), HttpStatus.OK);
    }

}
