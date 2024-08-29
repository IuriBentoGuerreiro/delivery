package com.iuri.delivery.controller;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import com.iuri.delivery.dto.delivery.DeliveryResponse;
import com.iuri.delivery.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponse save(@Valid @RequestBody DeliveryRequest deliveryRequest){
        return deliveryService.save(deliveryRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryResponse> findAll(){
        return deliveryService.findAll();
    }
}
