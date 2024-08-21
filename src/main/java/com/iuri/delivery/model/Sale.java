package com.iuri.delivery.model;

import com.iuri.delivery.dto.sale.SaleRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "sale")
    private List<Product> products;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "delivery_address")
    private String deliveryAddress;

    public Sale(Integer id){
        this.id = id;
    }

    public static Sale convert(SaleRequest saleRequest) {
        return Sale.builder()
                .products(saleRequest.getProducts().stream()
                        .map(Product::new).toList())
                .saleDate(saleRequest.getSaleDate())
                .totalAmount(saleRequest.getTotalAmount())
                .deliveryAddress(saleRequest.getDeliveryAddress())
                .build();
    }
}
