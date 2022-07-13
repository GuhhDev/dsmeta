package com.gustavoprojects.dsmeta.services;

import com.gustavoprojects.dsmeta.entities.Sale;
import com.gustavoprojects.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }
}
