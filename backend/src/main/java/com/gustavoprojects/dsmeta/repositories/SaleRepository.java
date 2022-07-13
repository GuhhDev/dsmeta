package com.gustavoprojects.dsmeta.repositories;

import com.gustavoprojects.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
