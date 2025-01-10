package com.felipecordeiro.pdv.services;

import com.felipecordeiro.pdv.dto.SaleDTO;
import com.felipecordeiro.pdv.dto.SaleItemDTO;
import com.felipecordeiro.pdv.dto.SaleResponseDTO;
import com.felipecordeiro.pdv.models.PaymentMethod;
import com.felipecordeiro.pdv.models.Product;
import com.felipecordeiro.pdv.models.Sale;
import com.felipecordeiro.pdv.models.SaleItem;
import com.felipecordeiro.pdv.repositories.PaymentMethodRepository;
import com.felipecordeiro.pdv.repositories.ProductRepository;
import com.felipecordeiro.pdv.repositories.SaleItemRepository;
import com.felipecordeiro.pdv.repositories.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository repository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final SaleItemRepository saleItemRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository repository, PaymentMethodRepository paymentMethodRepository, SaleItemRepository saleItemRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.saleItemRepository = saleItemRepository;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<SaleResponseDTO> findAll() {
        List<Sale> list = repository.findAll();
        return list.stream().map(SaleResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public SaleResponseDTO findById(Long id) {
        Sale entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado"));
        return new SaleResponseDTO(entity);
    }

    @Transactional
    public SaleResponseDTO create(SaleDTO dto) {
        Sale entity = new Sale();
        entity.setDate(LocalDateTime.now());

        PaymentMethod paymentMethod = paymentMethodRepository.findById(dto.paymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException("Metódo de pagamento inválido."));

        entity.setPaymentMethod(paymentMethod);

        for (SaleItemDTO item : dto.items()) {
            SaleItem saleItem = new SaleItem();
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
            saleItem.setProduct(product);
            saleItem.setSale(entity);
            saleItem.setQuantity(item.quantity());
            saleItem.setPrice(product.getPrice());
            saleItem.setSubtotal(saleItem.calculateSubtotal());

            entity.addSaleItems(saleItem);
        }

        entity = repository.save(entity);
        return new SaleResponseDTO(entity);
    }
}
