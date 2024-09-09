package com.iuri.delivery.controller;

import com.iuri.delivery.dto.deliveryRating.DeliveryRatingRequest;
import com.iuri.delivery.dto.deliveryRating.DeliveryRatingResponse;
import com.iuri.delivery.service.DeliveryRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Delivery Rating")
@RestController
@RequestMapping("/rating")
public class DeliveryRatingController {

    @Autowired
    private DeliveryRatingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public DeliveryRatingResponse save(DeliveryRatingRequest request){
        return service.save(request);
    }
}
