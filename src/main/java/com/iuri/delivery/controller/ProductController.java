package com.iuri.delivery.controller;

import com.iuri.delivery.dto.product.ProductRequest;
import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponse save(ProductRequest productRequest){
        return productService.save(productRequest);
    }

    @GetMapping
    public List<ProductResponse> findAll(){
        return productService.findAll();
    }
}
