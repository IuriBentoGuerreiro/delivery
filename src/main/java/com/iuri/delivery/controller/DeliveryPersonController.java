package com.iuri.delivery.controller;

import com.iuri.delivery.dto.deliveryPerson.DeliveryPersonDTO;
import com.iuri.delivery.model.DeliveryPerson;
import com.iuri.delivery.service.DeliveryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveryPerson")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping
    public DeliveryPerson save(@RequestBody DeliveryPersonDTO deliveryPersonDTO){
        return deliveryPersonService.save(deliveryPersonDTO);
    }
}
