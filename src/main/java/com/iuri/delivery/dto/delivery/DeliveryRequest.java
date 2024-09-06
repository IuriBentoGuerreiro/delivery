package com.iuri.delivery.dto.delivery;

import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.model.Sale;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeliveryRequest {

    @NotNull
    private List<SaleRequest> saleRequests;
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
