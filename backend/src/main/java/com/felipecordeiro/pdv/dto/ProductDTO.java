package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.Product;

public record ProductDTO(Long id, String name, String description, Double price, Integer stockQuantity, Integer lowStockThreshold, Boolean active, Long categoryId) {
    public ProductDTO(Product entity) {
        this(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getStockQuantity(), entity.getLowStockThreshold(), entity.getActive(), entity.getCategory().getId());
    }
}
