package com.iuri.delivery.controller;

import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.dto.sale.SaleResponse;
import com.iuri.delivery.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleResponse save(@Valid @RequestBody SaleRequest saleRequest){
        return saleService.save(saleRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SaleResponse> findAll(){
        return saleService.findAll();
    }
}
