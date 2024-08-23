package com.iuri.delivery.dto.sale;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleRequest {

    @NotNull
    private List<Integer> productId;
    @NotNull
    @PastOrPresent
    private LocalDateTime saleDate;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal totalAmount;
    @NotBlank
    private String deliveryAddress;
}
