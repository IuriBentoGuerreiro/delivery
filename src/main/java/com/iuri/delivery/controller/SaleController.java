package com.iuri.delivery.controller;

import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.dto.sale.SaleResponse;
import com.iuri.delivery.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public SaleResponse save(@RequestBody SaleRequest saleRequest){
        return saleService.save(saleRequest);
    }

    @GetMapping
    public List<SaleResponse> findAll(){
        return saleService.findAll();
    }
}
