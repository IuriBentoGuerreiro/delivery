package com.iuri.delivery.controller;

import com.iuri.delivery.dto.sale.SaleRequest;
import com.iuri.delivery.dto.sale.SaleResponse;
import com.iuri.delivery.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sale")
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "save")
    public SaleResponse save(@Valid @RequestBody SaleRequest saleRequest){
        return saleService.save(saleRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "findAll")
    public List<SaleResponse> findAll(){
        return saleService.findAll();
    }
}
