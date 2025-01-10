package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.Product;

public record ProductFindByIdDTO(Long id, String name, Double price, Integer stockQuantity, Boolean active,
                                 CategoryDTO category) {

    public ProductFindByIdDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity(), product.getActive(), new CategoryDTO(product.getCategory()));
    }
}
