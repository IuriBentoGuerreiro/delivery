package com.iuri.delivery.dto.sale;

import com.iuri.delivery.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleRequest {

    private List<Integer> products;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private String deliveryAddress;
}
