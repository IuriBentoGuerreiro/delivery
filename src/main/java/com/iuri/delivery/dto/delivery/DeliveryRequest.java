package com.iuri.delivery.dto.delivery;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRequest {

    private Integer saleId;
    private Integer deliveryPersonId;
    private String deliveryStatus;
    private LocalDateTime departureTime;
    private LocalDateTime deliveryTime;
    private String currentLocation;
}
