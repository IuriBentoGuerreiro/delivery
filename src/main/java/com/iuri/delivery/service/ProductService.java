package com.iuri.delivery.service;

import com.iuri.delivery.dto.product.ProductRequest;
import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.model.Product;
import com.iuri.delivery.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse save(ProductRequest productRequest){
        return ProductResponse.convert(productRepository.save(Product.convert(productRequest)));
    }

    public List<ProductResponse> findAll(){
        return productRepository.findAll().stream()
                .map(ProductResponse::convert).toList();
    }

    public Product findById(Integer id){
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found"));
    }

    public Product update(ProductRequest productRequest, Integer id){
        var product = findById(id);
        BeanUtils.copyProperties(productRequest, product, "id");
        return productRepository.save(product);
    }

    public void delete(Integer id){
        var product = findById(id);
        productRepository.delete(product);
    }

    public List<Product> findAllById(List<Integer> ids){
        return productRepository.findAllById(ids);
    }
}
