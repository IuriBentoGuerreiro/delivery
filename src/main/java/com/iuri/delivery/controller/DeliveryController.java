package com.iuri.delivery.controller;

import com.iuri.delivery.dto.delivery.DeliveryRequest;
import com.iuri.delivery.dto.delivery.DeliveryResponse;
import com.iuri.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public DeliveryResponse save(@RequestBody DeliveryRequest deliveryRequest){
        return deliveryService.save(deliveryRequest);
    }
}
