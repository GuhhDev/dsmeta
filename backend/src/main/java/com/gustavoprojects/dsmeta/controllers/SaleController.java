package com.gustavoprojects.dsmeta.controllers;

import com.gustavoprojects.dsmeta.entities.Sale;
import com.gustavoprojects.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping
    public List<Sale> findSales(){
        return saleService.findSales();
    }
}
