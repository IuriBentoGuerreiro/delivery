package com.iuri.delivery.controller;

import com.iuri.delivery.dto.product.ProductRequest;
import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public ProductResponse save(@Valid @RequestBody ProductRequest productRequest){
        return productService.save(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "findAll")
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }
}
