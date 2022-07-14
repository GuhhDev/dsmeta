package com.gustavoprojects.dsmeta.controllers;

import com.gustavoprojects.dsmeta.entities.Sale;
import com.gustavoprojects.dsmeta.services.SaleService;
import com.gustavoprojects.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSales(minDate,maxDate,pageable);
    }

    @GetMapping("/{id}notification")
    public void sendNotifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
