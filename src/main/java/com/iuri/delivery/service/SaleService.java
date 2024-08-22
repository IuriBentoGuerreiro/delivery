package com.iuri.delivery.service;

import com.iuri.delivery.dto.product.ProductResponse;
import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.dto.sale.SaleResponse;
import com.iuri.delivery.model.Sale;
import com.iuri.delivery.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;

    @Autowired
    public SaleService(SaleRepository saleRepository, ProductService productService) {
        this.saleRepository = saleRepository;
        this.productService = productService;
    }

    public SaleResponse save(SaleRequest saleRequest){
        var product = saleRepository.save(Sale.builder()
                        .products(productService.findAllById(saleRequest.getProductId()))
                        .deliveryAddress(saleRequest.getDeliveryAddress())
                        .totalAmount(saleRequest.getTotalAmount())
                        .saleDate(LocalDateTime.now())
                .build());

        return SaleResponse.convert(product);
    }

    public List<SaleResponse> findAll(){
        return saleRepository.findAll().stream()
                .map(SaleResponse::convert).toList();
    }

    public Sale findById(Integer id){
        return saleRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found"));
    }
}
