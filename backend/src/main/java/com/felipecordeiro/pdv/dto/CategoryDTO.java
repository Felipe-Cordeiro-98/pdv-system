package com.felipecordeiro.pdv.dto;

import com.felipecordeiro.pdv.models.Category;

public record CategoryDTO(Long id, String name) {
    public CategoryDTO(Category category) {
        this(category.getId(), category.getName());
    }
}
