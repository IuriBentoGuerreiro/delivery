package com.iuri.delivery.dto.delivery;

import com.iuri.delivery.model.Sale;
import com.iuri.delivery.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRequest {

    private Sale sale;
    private User deliveryPerson;
    private String deliveryStatus;
    private LocalDateTime departureTime;
    private LocalDateTime deliveryTime;
    private String currentLocation;
}
