package com.iuri.delivery.dto.delivery;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRequest {

    @NotNull
    private Integer saleId;
    @NotNull
    private Integer deliveryPersonId;
    @NotBlank
    private String deliveryStatus;
    @NotNull
    @FutureOrPresent
    private LocalDateTime departureTime;
    @NotNull
    @FutureOrPresent
    private LocalDateTime deliveryTime;
    @NotBlank
    private String currentLocation;
}
