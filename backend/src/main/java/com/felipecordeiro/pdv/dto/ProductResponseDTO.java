package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.Product;

public record ProductResponseDTO(Long id, String name, Double price, Integer stockQuantity, CategoryDTO category) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity(), new CategoryDTO(product.getCategory()));
    }
}
