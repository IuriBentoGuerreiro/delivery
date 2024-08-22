package com.iuri.delivery.model;

import com.iuri.delivery.dto.product.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "stock-quantity")
    private Integer stockQuantity;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
    private List<Sale> sale;

    public Product(Integer id) {
        this.id = id;
    }

    public static Product convert(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .stockQuantity(productRequest.getStockQuantity())
                .imageUrl(productRequest.getImageUrl())
                .build();
    }
}
