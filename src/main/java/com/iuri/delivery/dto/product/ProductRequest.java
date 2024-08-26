package com.iuri.delivery.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {


    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @NotNull
    @Min(value = 0)
    private Integer stockQuantity;

    private String imageUrl;
}
