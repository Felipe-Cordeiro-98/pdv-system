package com.felipecordeiro.pdv.repositories;

import com.felipecordeiro.pdv.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
