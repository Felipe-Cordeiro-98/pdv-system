package com.felipecordeiro.pdv.services;

import com.felipecordeiro.pdv.dto.ProductFindByIdDTO;
import com.felipecordeiro.pdv.dto.ProductResponseDTO;
import com.felipecordeiro.pdv.dto.ProductDTO;
import com.felipecordeiro.pdv.exceptions.ProductNotActiveException;
import com.felipecordeiro.pdv.models.Category;
import com.felipecordeiro.pdv.models.Product;
import com.felipecordeiro.pdv.repositories.CategoryRepository;
import com.felipecordeiro.pdv.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {
        List<Product> list = repository.findAllActiveProducts();
        return list.stream().map(ProductResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductFindByIdDTO findById(Long id) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado"));
        return new ProductFindByIdDTO(entity);
    }

    @Transactional
    public ProductResponseDTO create(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setPrice(dto.price());
        entity.adjustStock(dto.stockQuantity());
        entity.setLowStockThreshold(dto.lowStockThreshold());
        Category category = categoryRepository.findById(dto.categoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Não existe categoria para o ID informado"));

        entity.setCategory(category);
        entity = repository.save(entity);

        return new ProductResponseDTO(entity);
    }

    @Transactional
    public ProductFindByIdDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.getReferenceById(id);
            entity.setName(dto.name());
            entity.setDescription(dto.description());
            entity.setPrice(dto.price());
            entity.adjustStock(dto.stockQuantity());
            entity.setLowStockThreshold(dto.lowStockThreshold());
            entity.setActive(dto.active());

            Category category = categoryRepository.findById(dto.categoryId())
                    .orElseThrow(() -> new EntityNotFoundException("Não existe categoria para o ID informado"));

            entity.setCategory(category);
            entity = repository.save(entity);

            return new ProductFindByIdDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Não é possível atualizar produto com ID " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado"));

        if (!entity.getActive()) {
            throw new ProductNotActiveException("Produto já desativado");
        }
        entity.setActive(false);
        repository.save(entity);
    }
}
