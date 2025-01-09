-- Inserindo categorias para o PDV da lanchonete
INSERT INTO tb_category (name, description) VALUES ('Pastéis', 'Diversos sabores de pastéis salgados');
INSERT INTO tb_category (name, description) VALUES ('Bebidas', 'Bebidas variadas como refrigerantes, sucos e água');
INSERT INTO tb_category (name, description) VALUES ('Bebidas Alcoólicas', 'Cervejas e outras bebidas alcoólicas');
INSERT INTO tb_category (name, description) VALUES ('Acompanhamentos', 'Acompanhamentos como batata frita e porções');

-- Inserindo métodos de pagamento na tabela tb_payment_method
INSERT INTO tb_payment_method (name) VALUES ('Dinheiro');
INSERT INTO tb_payment_method (name) VALUES ('Cartão de Crédito');
INSERT INTO tb_payment_method (name) VALUES ('Cartão de Débito');
INSERT INTO tb_payment_method (name) VALUES ('PIX');

-- Inserindo produtos na tabela tb_product
INSERT INTO tb_product (name, description, price, stock_quantity, low_stock_threshold, category_id) VALUES ('Pastel de Carne', 'Pastel recheado com carne moída', 5.00, 20, 5, 1);
INSERT INTO tb_product (name, description, price, stock_quantity, low_stock_threshold, category_id) VALUES ('Coca-Cola Lata', 'Refrigerante Coca-Cola 350ml', 4.50, 50, 10, 2);
INSERT INTO tb_product (name, description, price, stock_quantity, low_stock_threshold, category_id) VALUES ('Cerveja Skol Lata', 'Cerveja Skol 350ml', 6.00, 30, 5, 3);
INSERT INTO tb_product (name, description, price, stock_quantity, low_stock_threshold, category_id) VALUES ('Batata Frita', 'Porção de batata frita 300g', 12.00, 10, 2, 4);
INSERT INTO tb_product (name, description, price, stock_quantity, low_stock_threshold, category_id) VALUES ('Suco Natural de Laranja', 'Copo de suco natural de laranja', 7.00, 15, 3, 2);

-- Inserindo uma venda com método de pagamento
INSERT INTO tb_sale (date, total_amount, payment_method_id) VALUES ('2025-01-09 14:30:00', 50.00, 1);
INSERT INTO tb_sale (date, total_amount, payment_method_id) VALUES ('2025-01-09 15:00:00', 75.00, 2);

-- Inserindo itens da venda
INSERT INTO tb_sale_item (quantity, price, subtotal, product_id, sale_id) VALUES (2, 5.00, 10.00, 1, 1);
INSERT INTO tb_sale_item (quantity, price, subtotal, product_id, sale_id) VALUES (4, 10.00, 40.00, 2, 1);
INSERT INTO tb_sale_item (quantity, price, subtotal, product_id, sale_id) VALUES (1, 25.00, 25.00, 3, 2);
INSERT INTO tb_sale_item (quantity, price, subtotal, product_id, sale_id) VALUES (2, 25.00, 50.00, 4, 2);


