package com.felipecordeiro.pdv.dto;

import java.util.List;

public record SaleDTO(List<SaleItemDTO> items, Long paymentMethodId) {
}
