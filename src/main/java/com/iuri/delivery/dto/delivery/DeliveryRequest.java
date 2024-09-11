package com.iuri.delivery.dto.delivery;

import com.iuri.delivery.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryRequest {

    @NotNull
    private Integer saleId;
    @NotNull
    private Integer client;
    @NotNull
    private Integer deliveryPersonId;
    @NotBlank
    private String deliveryStatus;
    @NotNull
    private LocalDateTime departureTime;
    @NotNull
    private LocalDateTime deliveryTime;
    @NotBlank
    private String currentLocation;
}
