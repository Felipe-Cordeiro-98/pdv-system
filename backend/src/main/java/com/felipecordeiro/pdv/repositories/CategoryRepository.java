package com.felipecordeiro.pdv.repositories;

import com.felipecordeiro.pdv.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
