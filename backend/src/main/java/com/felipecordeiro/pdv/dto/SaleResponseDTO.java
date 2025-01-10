package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.Sale;

import java.time.LocalDateTime;
import java.util.List;

public record SaleResponseDTO(Long id, LocalDateTime date, Double totalAmount, List<SaleItemResponseDTO> items, String paymentMethod) {
    public SaleResponseDTO(Sale sale) {
        this(sale.getId(), sale.getDate(), sale.calculateTotal(), sale.getSaleItems().stream().map(SaleItemResponseDTO::new).toList(), sale.getPaymentMethod().getName());
    }
}
