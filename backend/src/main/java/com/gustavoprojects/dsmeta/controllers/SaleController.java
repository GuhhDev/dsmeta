package com.gustavoprojects.dsmeta.controllers;

import com.gustavoprojects.dsmeta.entities.Sale;
import io.swagger.annotations.Api;
import com.gustavoprojects.dsmeta.services.SaleService;
import com.gustavoprojects.dsmeta.services.SmsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
@Api(value = "/sales", tags = "DSMeta API", description = "API Para Consultar Vendas e Enviar Notificacao via SMS com os Dados dos Melhores Vendedores")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping
    @ApiOperation(value = "Fetch all sales details", notes = "get all sales")
    public Page<Sale> findSales(
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    @ApiOperation(value = "Send a SMS notification by Id Sale", notes = "sends a notification SMS with the Best Seller Details")
    public void sendNotifySmsWithId(@PathVariable Long id){
        smsService.sendSmsWithId(id);
    }

    @GetMapping("/notification")
    public void sendNotifySms(){
        smsService.sendSms();
    }
}
