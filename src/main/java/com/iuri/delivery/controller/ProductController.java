package com.iuri.delivery.controller;

import com.iuri.delivery.dto.product.ProductRequest;
import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest){
        return productService.save(productRequest);
    }

    @GetMapping
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }
}
