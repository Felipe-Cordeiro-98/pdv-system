package com.felipecordeiro.pdv.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testAdjustStockWhenValueIsNegative() {
        // Arrange
        Product product = new Product();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> product.adjustStock(-10));
    }

    @Test
    void testAdjustStockWhenValueIsPositive() {
        // Arrange
        Product product = new Product();

        // Act
        product.adjustStock(10);

        // Assert
        assertEquals(10, product.getStockQuantity());
    }

    @Test
    void testIsLowStockWhenTrue() {
        // Arrange
        Product product = new Product();

        // Act
        product.setStockQuantity(10);
        product.setLowStockThreshold(11);

        // Arrange
        assertTrue(product.isLowStock());
    }

    @Test
    void testIsLowStockWhenFalse() {
        // Arrange
        Product product1 = new Product();
        Product product2 = new Product();

        // Act
        product1.setStockQuantity(10);
        product1.setLowStockThreshold(10);

        product2.setStockQuantity(10);
        product2.setLowStockThreshold(8);

        // Arrange
        assertFalse(product1.isLowStock());
        assertFalse(product2.isLowStock());
    }
}
