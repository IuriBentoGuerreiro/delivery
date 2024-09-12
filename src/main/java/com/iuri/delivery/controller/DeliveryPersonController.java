package com.iuri.delivery.controller;

import com.iuri.delivery.dto.deliveryPerson.DeliveryPersonDTO;
import com.iuri.delivery.model.DeliveryPerson;
import com.iuri.delivery.service.DeliveryPersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Delivery person")
@RestController
@RequestMapping("/deliveryPerson")
public class DeliveryPersonController {

    @Autowired
    private DeliveryPersonService deliveryPersonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public DeliveryPerson save(@RequestBody DeliveryPersonDTO deliveryPersonDTO){
        return deliveryPersonService.save(deliveryPersonDTO);
    }
}
