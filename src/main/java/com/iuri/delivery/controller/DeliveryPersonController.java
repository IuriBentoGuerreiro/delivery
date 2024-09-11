package com.iuri.delivery.controller;

import com.iuri.delivery.model.DeliveryPerson;
import com.iuri.delivery.service.DeliveryPersonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryPerson")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping
    public DeliveryPerson save(@RequestBody DeliveryPerson deliveryPerson){
        return deliveryPersonService.save(deliveryPerson);
    }
}
