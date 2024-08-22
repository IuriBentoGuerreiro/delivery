package com.iuri.delivery.service;

import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.dto.sale.SaleResponse;
import com.iuri.delivery.model.Sale;
import com.iuri.delivery.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public SaleResponse save(SaleRequest saleRequest){
        return SaleResponse.convert(saleRepository.save(Sale.convert(saleRequest)));
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
