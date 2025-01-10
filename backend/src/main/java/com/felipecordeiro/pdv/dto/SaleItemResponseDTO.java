package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.SaleItem;

public record SaleItemResponseDTO(String productName, Integer quantity, Double price, Double subtotal) {
    public SaleItemResponseDTO(SaleItem saleItems) {
        this(saleItems.getProduct().getName(), saleItems.getQuantity(), saleItems.getPrice(), saleItems.calculateSubtotal());
    }
}
