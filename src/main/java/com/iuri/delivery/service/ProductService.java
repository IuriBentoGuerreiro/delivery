package com.iuri.delivery.service;

import com.iuri.delivery.dto.product.ProductRequest;
import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.model.Product;
import com.iuri.delivery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse save(ProductRequest productRequest){
        return ProductResponse.convert(productRepository.save(Product.convert(productRequest)));
    }
}
