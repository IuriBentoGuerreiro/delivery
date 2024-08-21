package com.iuri.delivery.dto.sale;

import com.iuri.delivery.model.Product;
import com.iuri.delivery.model.Sale;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SaleResponse {

    private Integer id;
    private List<Product> products;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;
    private String deliveryAddress;

    public static SaleResponse convert(Sale sale) {
        return SaleResponse.builder()
                .id(sale.getId())
                .products(sale.getProducts())
                .saleDate(sale.getSaleDate())
                .totalAmount(sale.getTotalAmount())
                .deliveryAddress(sale.getDeliveryAddress())
                .build();
    }
}
