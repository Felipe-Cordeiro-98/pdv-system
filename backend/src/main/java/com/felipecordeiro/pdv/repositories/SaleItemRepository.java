package com.felipecordeiro.pdv.repositories;

import com.felipecordeiro.pdv.models.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
